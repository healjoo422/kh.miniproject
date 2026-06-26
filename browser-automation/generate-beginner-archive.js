const fs = require('fs/promises');
const path = require('path');
const { spawn } = require('child_process');
const { chromium } = require('playwright');

const DEBUG_ENDPOINT = 'http://127.0.0.1:9222';
const BEGINNER_URL = 'https://school.programmers.co.kr/learn/challenges/beginner';
const OUTPUT_DIR = path.resolve('C:/workspace/Beginner');
const TARGET_COUNT = 100;
const COPILOT_COMMAND = 'copilot';

function hasFlag(flag) {
  return process.argv.includes(flag);
}

function toIdentifier(index) {
  return `Solution_${String(index).padStart(3, '0')}`;
}

function sanitizeFileName(title) {
  return title.replace(/[\\/:*?"<>|]/g, '_').trim();
}

function dedupeFileName(baseName, seenNames) {
  let attempt = baseName;
  let duplicateCount = 2;

  while (seenNames.has(`${attempt}.java`)) {
    attempt = `${baseName}(_${duplicateCount})`;
    duplicateCount += 1;
  }

  seenNames.add(`${attempt}.java`);
  return `${attempt}.java`;
}

function cleanLine(line) {
  return line.replace(/\s+/g, ' ').trim();
}

function parseSections(bodyText) {
  const headings = ['문제 설명', '제한사항', '입출력 예', '입출력 예 설명'];
  const sections = Object.fromEntries(headings.map((heading) => [heading, []]));
  const lines = bodyText
    .split(/\r?\n/)
    .map((line) => line.trim())
    .filter(Boolean);

  let currentHeading = null;

  for (const line of lines) {
    if (headings.includes(line)) {
      currentHeading = line;
      continue;
    }

    if (currentHeading) {
      sections[currentHeading].push(line);
    }
  }

  return Object.fromEntries(
    Object.entries(sections).map(([heading, value]) => [heading, value.join('\n').trim()])
  );
}

function summarizeProblem(problem) {
  const description = problem.sections['문제 설명']
    .split('\n')
    .map(cleanLine)
    .filter(Boolean)
    .slice(0, 2)
    .join(' ');

  const constraints = problem.sections['제한사항']
    .split('\n')
    .map(cleanLine)
    .filter(Boolean)
    .slice(0, 4);

  const examples = problem.sections['입출력 예']
    .split('\n')
    .map(cleanLine)
    .filter(Boolean)
    .slice(0, 6);

  return {
    description: description || '문제 설명 요약을 추출하지 못했습니다.',
    constraints,
    examples,
  };
}

function buildPrompt(problem, className) {
  return [
    'You are solving a beginner Java coding challenge from Programmers.',
    'Return strict JSON only with keys: summary, approach, javaCode.',
    'Rules for javaCode:',
    `- The top-level declaration must be exactly: class ${className}`,
    '- Do not use package declarations.',
    '- Use only standard Java.',
    '- The method signature must match the problem as presented.',
    '- Output only compilable code in javaCode, with no markdown fences.',
    'Rules for summary:',
    '- Summarize the problem in Korean in 1-2 sentences.',
    '- Do not quote the source text verbatim.',
    'Rules for approach:',
    '- Explain the core idea in Korean in 1-3 short sentences.',
    '',
    `Title: ${problem.title}`,
    `URL: ${problem.url}`,
    '',
    '[Problem Description]',
    problem.sections['문제 설명'] || '',
    '',
    '[Constraints]',
    problem.sections['제한사항'] || '',
    '',
    '[Examples]',
    problem.sections['입출력 예'] || '',
    '',
    '[Example Explanation]',
    problem.sections['입출력 예 설명'] || '',
  ].join('\n');
}

async function runCopilotPrompt(prompt, model) {
  const command =
    process.platform === 'win32'
      ? 'powershell.exe'
      : COPILOT_COMMAND;

  const args =
    process.platform === 'win32'
      ? [
          '-NoProfile',
          '-Command',
          "copilot -p $env:COPILOT_PROMPT --model $env:COPILOT_MODEL --allow-all-tools --no-custom-instructions --no-ask-user --no-color --stream off -s",
        ]
      : [
          '-p',
          prompt,
          '--model',
          model,
          '--allow-all-tools',
          '--no-custom-instructions',
          '--no-ask-user',
          '--no-color',
          '--stream',
          'off',
          '-s',
        ];

  return new Promise((resolve, reject) => {
    const child = spawn(command, args, {
      cwd: path.resolve('C:/workspace/browser-automation'),
      env: {
        ...process.env,
        COPILOT_PROMPT: prompt,
        COPILOT_MODEL: model,
      },
    });

    let stdout = '';
    let stderr = '';

    child.stdout.on('data', (chunk) => {
      stdout += chunk.toString();
    });

    child.stderr.on('data', (chunk) => {
      stderr += chunk.toString();
    });

    child.on('error', (error) => {
      reject(error);
    });

    child.on('close', (code) => {
      if (code === 0) {
        resolve({ stdout, stderr });
        return;
      }

      const error = new Error(`Copilot CLI exited with code ${code}`);
      error.stdout = stdout;
      error.stderr = stderr;
      reject(error);
    });
  });
}

async function generateSolution(problem, className) {
  const model = process.env.COPILOT_MODEL || process.env.OPENAI_MODEL || 'gpt-5.4';
  const prompt = buildPrompt(problem, className);

  let stdout;
  let stderr;
  try {
    const result = await runCopilotPrompt(prompt, model);
    stdout = result.stdout;
    stderr = result.stderr;
  } catch (error) {
    const stderr = String(error.stderr || '').trim();
    const stdoutText = String(error.stdout || '').trim();
    const combined = [stderr, stdoutText].filter(Boolean).join('\n');

    if (combined.includes('No authentication information found')) {
      throw new Error(
        'Copilot CLI is not authenticated. Run `copilot`, then `/login`, or run `gh auth login`, and retry.'
      );
    }

    throw new Error(`Copilot CLI request failed: ${combined || error.message}`);
  }

  const content = String(stdout || '').trim();
  const stderrText = String(stderr || '').trim();

  if (stderrText.includes('No authentication information found')) {
    throw new Error(
      'Copilot CLI is not authenticated. Run `copilot`, then `/login`, or run `gh auth login`, and retry.'
    );
  }

  if (!content) {
    throw new Error('Copilot CLI did not return any content.');
  }

  let parsed;
  try {
    parsed = JSON.parse(content);
  } catch (error) {
    throw new Error(`Failed to parse Copilot CLI JSON: ${error.message}\nRaw output:\n${content}`);
  }

  if (!parsed.javaCode || !parsed.summary || !parsed.approach) {
    throw new Error('Copilot CLI JSON is missing summary, approach, or javaCode.');
  }

  return {
    summary: cleanLine(parsed.summary),
    approach: cleanLine(parsed.approach),
    javaCode: String(parsed.javaCode).trim(),
  };
}

function buildJavaFile(problem, archive, generated) {
  const lines = [
    '/*',
    `문제명: ${problem.title}`,
    `링크: ${problem.url}`,
    `요약: ${generated.summary}`,
    `접근: ${generated.approach}`,
  ];

  if (archive.constraints.length > 0) {
    lines.push('제한사항:');
    archive.constraints.forEach((constraint) => lines.push(`- ${constraint}`));
  }

  if (archive.examples.length > 0) {
    lines.push('입출력 예:');
    archive.examples.forEach((example) => lines.push(`- ${example}`));
  }

  lines.push('*/', '', generated.javaCode, '');
  return lines.join('\n');
}

async function connectBrowser() {
  return chromium.connectOverCDP(DEBUG_ENDPOINT);
}

async function getProgrammersPage(browser) {
  const existingPage = browser
    .contexts()
    .flatMap((context) => context.pages())
    .find((page) => page.url().includes('school.programmers.co.kr'));

  if (existingPage) {
    return existingPage;
  }

  const context = browser.contexts()[0] || (await browser.newContext());
  return context.newPage();
}

async function collectBeginnerProblems(page) {
  const problems = [];
  const seenUrls = new Set();

  for (let pageNumber = 1; pageNumber <= 20; pageNumber += 1) {
    await page.goto(`${BEGINNER_URL}?page=${pageNumber}`, { waitUntil: 'domcontentloaded' });
    await page.waitForLoadState('networkidle');

    const rows = await page.locator('table tbody tr').evaluateAll((tableRows) => {
      return tableRows
        .map((tableRow) => {
          const cells = tableRow.querySelectorAll('td');
          const titleCell = cells[1];
          const titleLink = titleCell?.querySelector('a[href*="/learn/courses/30/lessons/"]');

          if (!titleCell || !titleLink) {
            return null;
          }

          return {
            title: (titleLink.textContent || '').replace(/\s+/g, ' ').trim(),
            url: titleLink.href,
          };
        })
        .filter(Boolean);
    });

    if (rows.length === 0) {
      break;
    }

    let addedOnPage = 0;
    for (const row of rows) {
      if (seenUrls.has(row.url)) {
        continue;
      }

      seenUrls.add(row.url);
      problems.push(row);
      addedOnPage += 1;
    }

    if (problems.length >= TARGET_COUNT || addedOnPage === 0) {
      break;
    }
  }

  return problems.slice(0, TARGET_COUNT);
}

async function collectProblemDetails(page, problem) {
  await page.goto(problem.url, { waitUntil: 'domcontentloaded' });
  await page.waitForLoadState('networkidle');

  const bodyText = await page.locator('body').innerText();
  return {
    ...problem,
    sections: parseSections(bodyText),
  };
}

async function ensureOutputDir() {
  await fs.mkdir(OUTPUT_DIR, { recursive: true });
}

async function main() {
  const dryRun = hasFlag('--dry-run');
  const browser = await connectBrowser();

  try {
    const page = await getProgrammersPage(browser);
    await page.bringToFront();

    const problems = await collectBeginnerProblems(page);
    if (problems.length !== TARGET_COUNT) {
      throw new Error(`Expected ${TARGET_COUNT} beginner problems, but found ${problems.length}.`);
    }

    console.log(`Collected ${problems.length} beginner problems.`);

    const fileNames = new Set();
    const manifest = [];

    for (const [index, baseProblem] of problems.entries()) {
      const order = index + 1;
      const className = toIdentifier(order);
      const fileName = dedupeFileName(sanitizeFileName(baseProblem.title), fileNames);

      manifest.push({
        order,
        title: baseProblem.title,
        url: baseProblem.url,
        className,
        fileName,
      });
    }

    if (dryRun) {
      console.log(JSON.stringify(manifest.slice(0, 5), null, 2));
      return;
    }

    await ensureOutputDir();

    for (const entry of manifest) {
      const problem = await collectProblemDetails(page, entry);
      const archive = summarizeProblem(problem);
      const generated = await generateSolution(problem, entry.className);
      const javaFile = buildJavaFile(problem, archive, generated);
      const outputPath = path.join(OUTPUT_DIR, entry.fileName);

      await fs.writeFile(outputPath, javaFile, 'utf8');
      console.log(`Wrote ${entry.fileName}`);
    }
  } finally {
    await browser.close();
  }
}

main().catch((error) => {
  console.error(error?.stack || error?.message || error);
  process.exitCode = 1;
});
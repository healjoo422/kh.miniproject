const fs = require('fs/promises');
const path = require('path');
const { spawn } = require('child_process');

const INPUT_FILE = path.resolve('C:/workspace/Beginner/unsolved-problems.json');
const OUTPUT_DIR = path.resolve('C:/workspace/Beginner');
const COPILOT_COMMAND = 'copilot';

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

function sanitizeForPrompt(text) {
  // 큰따옴표를 작은따옴표로 대체 — shell 인자 파싱 오류 방지
  return (text || '').replace(/"/g, "'");
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
    sanitizeForPrompt(problem.sections['문제 설명']),
    '',
    '[Constraints]',
    sanitizeForPrompt(problem.sections['제한사항']),
  ].join('\n');
}

async function runCopilotPrompt(prompt, model) {
  const command = process.platform === 'win32' ? 'powershell.exe' : COPILOT_COMMAND;
  const args =
    process.platform === 'win32'
      ? [
          '-NoProfile',
          '-Command',
          'copilot -p $env:COPILOT_PROMPT --model $env:COPILOT_MODEL --no-custom-instructions --no-ask-user --no-color --stream off -s --output-format json',
        ]
      : ['-p', prompt, '--model', model, '--no-custom-instructions', '--no-ask-user', '--no-color', '--stream', 'off', '-s', '--output-format', 'json'];

  return new Promise((resolve, reject) => {
    const child = spawn(command, args, {
      cwd: path.resolve('C:/workspace/browser-automation'),
      env: { ...process.env, COPILOT_PROMPT: prompt, COPILOT_MODEL: model },
    });

    let stdout = '';
    let stderr = '';
    child.stdout.setEncoding('utf8');
    child.stderr.setEncoding('utf8');
    child.stdout.on('data', (chunk) => { stdout += chunk; });
    child.stderr.on('data', (chunk) => { stderr += chunk; });
    child.on('error', reject);
    child.on('close', (code) => {
      const lines = stdout.split('\n').filter((l) => l.trim().startsWith('{'));
      let content = '';

      for (const line of lines) {
        try {
          const obj = JSON.parse(line);
          if (obj.type === 'assistant.message' && obj.data && obj.data.content) {
            content = obj.data.content;
            break;
          }
        } catch { /* 무시 */ }
      }

      if (!content) {
        const deltaMap = new Map();
        for (const line of lines) {
          try {
            const obj = JSON.parse(line);
            if (obj.type === 'assistant.message_delta' && obj.data && obj.data.deltaContent) {
              const id = obj.data.messageId || 'default';
              deltaMap.set(id, (deltaMap.get(id) || '') + obj.data.deltaContent);
            }
          } catch { /* 무시 */ }
        }
        if (deltaMap.size > 0) content = [...deltaMap.values()][0];
      }

      if (code === 0) { resolve({ stdout: content, stderr }); return; }
      const error = new Error(`Copilot CLI exited with code ${code}`);
      error.stdout = content;
      error.stderr = stderr;
      reject(error);
    });
  });
}

async function generateSolution(problem, className) {
  const model = process.env.COPILOT_MODEL || process.env.OPENAI_MODEL || 'gpt-5.4';
  const prompt = buildPrompt(problem, className);

  let stdout, stderr;
  try {
    ({ stdout, stderr } = await runCopilotPrompt(prompt, model));
  } catch (error) {
    const combined = [String(error.stderr || ''), String(error.stdout || '')].filter(Boolean).join('\n');
    if (combined.includes('No authentication information found')) {
      throw new Error('Copilot CLI 인증 필요. `copilot` → `/login` 또는 `gh auth login` 실행 후 재시도하세요.');
    }
    throw new Error(`Copilot CLI 요청 실패: ${combined || error.message}`);
  }

  const content = String(stdout || '').trim();
  if (String(stderr || '').includes('No authentication information found')) {
    throw new Error('Copilot CLI 인증 필요. `copilot` → `/login` 또는 `gh auth login` 실행 후 재시도하세요.');
  }
  if (!content) throw new Error('Copilot CLI가 응답을 반환하지 않았습니다.');

  let parsed;
  try {
    parsed = JSON.parse(content);
  } catch (error) {
    throw new Error(`JSON 파싱 실패: ${error.message}\n원본 출력:\n${content}`);
  }

  if (!parsed.javaCode || !parsed.summary || !parsed.approach) {
    throw new Error('Copilot CLI 응답에 summary, approach, javaCode 중 누락된 항목이 있습니다.');
  }

  return {
    summary: cleanLine(parsed.summary),
    approach: cleanLine(parsed.approach),
    javaCode: String(parsed.javaCode).trim(),
  };
}

function buildJavaFile(problem, generated) {
  const constraints = (problem.sections['제한사항'] || '')
    .split('\n')
    .map(cleanLine)
    .filter(Boolean);

  const lines = [
    '/*',
    `문제명: ${problem.title}`,
    `링크: ${problem.url}`,
    `요약: ${generated.summary}`,
    `접근: ${generated.approach}`,
  ];

  if (constraints.length > 0) {
    lines.push('제한사항:');
    constraints.forEach((c) => lines.push(`- ${c}`));
  }

  lines.push('*/', '', generated.javaCode, '');
  return lines.join('\n');
}

async function main() {
  let problems;
  try {
    const raw = await fs.readFile(INPUT_FILE, 'utf8');
    problems = JSON.parse(raw);
  } catch {
    console.error(`JSON 파일을 읽을 수 없습니다: ${INPUT_FILE}`);
    console.error('"npm run collect:unsolved" 를 먼저 실행하세요.');
    process.exit(1);
  }

  console.log(`총 ${problems.length}개 미풀이 문제 풀이 생성 시작...\n`);
  await fs.mkdir(OUTPUT_DIR, { recursive: true });

  const seenNames = new Set();
  try {
    const existing = await fs.readdir(OUTPUT_DIR);
    existing.filter((f) => f.endsWith('.java')).forEach((f) => seenNames.add(f));
  } catch { /* 무시 */ }

  for (const [index, problem] of problems.entries()) {
    const order = index + 1;
    const className = toIdentifier(order);
    const expectedFileName = `${sanitizeFileName(problem.title)}.java`;
    const expectedPath = path.join(OUTPUT_DIR, expectedFileName);

    process.stdout.write(`[${order}/${problems.length}] ${problem.title} ... `);

    // 이미 파일이 존재하면 건너뜀
    try {
      await fs.access(expectedPath);
      console.log('건너뜀 (이미 존재)');
      seenNames.add(expectedFileName);
      continue;
    } catch { /* 파일 없음 → 생성 진행 */ }

    const fileName = dedupeFileName(sanitizeFileName(problem.title), seenNames);
    const outputPath = path.join(OUTPUT_DIR, fileName);

    try {
      const generated = await generateSolution(problem, className);
      const javaFile = buildJavaFile(problem, generated);
      await fs.writeFile(outputPath, javaFile, 'utf8');
      console.log(`저장 완료 → ${fileName}`);
    } catch (error) {
      console.log(`실패: ${error.message}`);
    }
  }

  console.log('\n모든 문제 처리 완료!');
}

main().catch((error) => {
  console.error(error?.stack || error?.message || error);
  process.exitCode = 1;
});

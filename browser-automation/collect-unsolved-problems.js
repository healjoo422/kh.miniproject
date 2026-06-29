const fs = require('fs/promises');
const path = require('path');
const { chromium } = require('playwright');

const DEBUG_ENDPOINT = 'http://127.0.0.1:9222';
const BEGINNER_URL = 'https://school.programmers.co.kr/learn/challenges/beginner';
const OUTPUT_FILE = path.resolve('C:/workspace/Beginner/unsolved-problems.json');

function parseSections(bodyText) {
  // 모든 헤딩을 인식해야 '제한사항' 뒤 내용이 섞이지 않음
  const allHeadings = ['문제 설명', '제한사항', '입출력 예', '입출력 예 설명'];
  const saveHeadings = new Set(['문제 설명', '제한사항']);
  const sections = { '문제 설명': [], '제한사항': [] };
  const lines = bodyText
    .split(/\r?\n/)
    .map((line) => line.trim())
    .filter(Boolean);

  let currentHeading = null;

  for (const line of lines) {
    if (allHeadings.includes(line)) {
      currentHeading = saveHeadings.has(line) ? line : null;
      continue;
    }
    if (currentHeading) {
      sections[currentHeading].push(line);
    }
  }

  return Object.fromEntries(
    Object.entries(sections).map(([h, v]) => [h, v.join('\n').trim()])
  );
}

async function collectUnsolvedList(page) {
  const unsolved = [];
  const seenUrls = new Set();

  for (let pageNumber = 1; pageNumber <= 20; pageNumber += 1) {
    await page.goto(`${BEGINNER_URL}?page=${pageNumber}`, { waitUntil: 'domcontentloaded' });
    await page.waitForLoadState('networkidle');

    const rows = await page.locator('table tbody tr').evaluateAll((tableRows) => {
      return tableRows
        .map((tr) => {
          const cells = tr.querySelectorAll('td');
          const statusCell = cells[0];
          const titleCell = cells[1];
          const titleLink = titleCell?.querySelector('a[href*="/learn/courses/30/lessons/"]');

          if (!statusCell || !titleCell || !titleLink) return null;

          return {
            title: (titleLink.textContent || '').replace(/\s+/g, ' ').trim(),
            url: titleLink.href,
            solved: typeof statusCell.className === 'string'
              ? statusCell.className.split(' ').includes('solved')
              : String(statusCell.className).split(' ').includes('solved'),
          };
        })
        .filter(Boolean);
    });

    if (rows.length === 0) break;

    let addedOnPage = 0;
    for (const row of rows) {
      if (seenUrls.has(row.url)) continue;
      seenUrls.add(row.url);

      if (!row.solved) {
        unsolved.push({ title: row.title, url: row.url });
        addedOnPage += 1;
      }
    }

    console.log(`  Page ${pageNumber}: ${rows.length} rows, ${addedOnPage} unsolved added (total: ${unsolved.length})`);

    // 페이지에 문제가 없으면 마지막 페이지
    if (rows.length < 10) break;
  }

  return unsolved;
}

async function collectProblemDetail(page, problem) {
  await page.goto(problem.url, { waitUntil: 'domcontentloaded' });
  await page.waitForLoadState('networkidle');

  const bodyText = await page.locator('body').innerText();
  const sections = parseSections(bodyText);

  return {
    title: problem.title,
    url: problem.url,
    sections,
  };
}

async function main() {
  let browser;
  try {
    browser = await chromium.connectOverCDP(DEBUG_ENDPOINT);
  } catch {
    console.error('Chrome 원격 디버깅 엔드포인트에 연결할 수 없습니다: ' + DEBUG_ENDPOINT);
    console.error('"npm run open:debug-chrome" 실행 후 다시 시도하세요.');
    process.exit(1);
  }

  try {
    const existingPage = browser
      .contexts()
      .flatMap((ctx) => ctx.pages())
      .find((p) => p.url().includes('school.programmers.co.kr'));

    const context = browser.contexts()[0] || (await browser.newContext());
    const page = existingPage || (await context.newPage());
    await page.bringToFront();

    console.log('미풀이 문제 목록 수집 중...');
    const unsolvedList = await collectUnsolvedList(page);
    console.log(`\n총 ${unsolvedList.length}개의 미풀이 문제 발견. 문제 내용 수집 중...\n`);

    const results = [];
    for (const [index, problem] of unsolvedList.entries()) {
      console.log(`[${index + 1}/${unsolvedList.length}] ${problem.title}`);
      const detail = await collectProblemDetail(page, problem);
      results.push(detail);
    }

    await fs.mkdir(path.dirname(OUTPUT_FILE), { recursive: true });
    await fs.writeFile(OUTPUT_FILE, JSON.stringify(results, null, 2), 'utf8');

    console.log(`\n완료! ${results.length}개 문제를 저장했습니다.`);
    console.log(`저장 위치: ${OUTPUT_FILE}`);
  } finally {
    await browser.close();
  }
}

main().catch((error) => {
  console.error(error?.stack || error?.message || error);
  process.exitCode = 1;
});

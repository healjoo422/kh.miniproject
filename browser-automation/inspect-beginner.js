const { chromium } = require('playwright');

function parseSections(bodyText) {
  const headingSet = new Set(['문제 설명', '제한사항', '입출력 예', '입출력 예 설명']);
  const lines = bodyText
    .split(/\r?\n/)
    .map((line) => line.trim())
    .filter(Boolean);

  const sections = {
    '문제 설명': [],
    제한사항: [],
    '입출력 예': [],
    '입출력 예 설명': [],
  };

  let currentSection = null;

  for (const line of lines) {
    if (headingSet.has(line)) {
      currentSection = line;
      continue;
    }

    if (currentSection) {
      sections[currentSection].push(line);
    }
  }

  return Object.fromEntries(
    Object.entries(sections).map(([key, value]) => [key, value.join('\n').trim()])
  );
}

async function main() {
  const browser = await chromium.connectOverCDP('http://127.0.0.1:9222');

  try {
    const page = browser
      .contexts()
      .flatMap((context) => context.pages())
      .find((currentPage) => currentPage.url().includes('school.programmers.co.kr'));

    if (!page) {
      throw new Error('No school.programmers.co.kr tab found in the debug Chrome session.');
    }

    await page.bringToFront();
    await page.goto('https://school.programmers.co.kr/learn/challenges/beginner', {
      waitUntil: 'domcontentloaded',
    });
    await page.waitForLoadState('networkidle');

    const paginationPages = await page.locator('a[href*="page="]').evaluateAll((links) => {
      return Array.from(
        new Set(
          links
            .map((link) => Number.parseInt((link.textContent || '').trim(), 10))
            .filter((pageNumber) => Number.isInteger(pageNumber) && pageNumber > 0)
        )
      ).sort((left, right) => left - right);
    });

    const pagesToScan = paginationPages.length > 0 ? paginationPages : [1];
    let selected = null;
    let selectionSource = 'fallback-first-visible';

    for (const pageNumber of pagesToScan) {
      await page.goto(`https://school.programmers.co.kr/learn/challenges/beginner?page=${pageNumber}`, {
        waitUntil: 'domcontentloaded',
      });
      await page.waitForLoadState('networkidle');

      const rows = await page.locator('table tbody tr').evaluateAll((tableRows) => {
        return tableRows
          .map((tableRow) => {
            const cells = tableRow.querySelectorAll('td');
            const statusCell = cells[0];
            const titleCell = cells[1];
            const titleLink = titleCell?.querySelector('a[href*="/learn/courses/30/lessons/"]');

            if (!statusCell || !titleCell || !titleLink) {
              return null;
            }

            return {
              title: (titleCell.textContent || '').replace(/\s+/g, ' ').trim(),
              href: titleLink.href,
              statusClasses:
                typeof statusCell.className === 'string'
                  ? statusCell.className
                  : String(statusCell.className),
            };
          })
          .filter(Boolean);
      });

      const unsolved = rows.find((row) => !row.statusClasses.includes('solved'));

      if (unsolved) {
        selected = unsolved;
        selectionSource = `first-unsolved-page-${pageNumber}`;
        break;
      }

      if (!selected && rows[0]) {
        selected = rows[0];
      }
    }

    if (!selected) {
      throw new Error('No beginner challenge rows were found.');
    }

    await page.goto(selected.href, { waitUntil: 'domcontentloaded' });
    await page.waitForLoadState('networkidle');

    const bodyText = await page.locator('body').innerText();
    const sections = parseSections(bodyText);

    const result = {
      selectedFromVisibleList: selectionSource,
      title: selected.title,
      url: selected.href,
      statusClasses: selected.statusClasses,
      sections,
    };

    console.log(JSON.stringify(result, null, 2));
  } finally {
    await browser.close();
  }
}

main().catch((error) => {
  console.error(error.message || error);
  process.exit(1);
});
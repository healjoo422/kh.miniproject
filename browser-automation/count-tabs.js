const { chromium } = require('playwright');

async function main() {
  let browser;

  try {
    browser = await chromium.connectOverCDP('http://127.0.0.1:9222');
  } catch (error) {
    console.error('Chrome remote debugging endpoint not found at http://127.0.0.1:9222');
    console.error('Close Chrome completely, run "npm run open:debug-chrome", then try again.');
    process.exit(1);
  }

  const pageCount = browser
    .contexts()
    .flatMap((context) => context.pages())
    .filter((page) => !page.url().startsWith('devtools://')).length;

  console.log(`Open tab count: ${pageCount}`);

  await browser.close();
}

main().catch((error) => {
  console.error(error);
  process.exit(1);
});
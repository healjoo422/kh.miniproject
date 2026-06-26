const { Builder, By, until } = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');

async function main() {
  const options = new chrome.Options();
  options.debuggerAddress('127.0.0.1:9222');

  const driver = await new Builder().forBrowser('chrome').setChromeOptions(options).build();

  try {
    const loginUrl = 'https://school.programmers.co.kr/';

    await driver.get(loginUrl);
    console.log('Attached to Chrome on port 9222.');
    console.log('Programmers page opened in your manually launched Chrome window.');
    console.log('If you are not logged in, sign in directly in that browser window.');

    await driver.wait(async () => {
      const currentUrl = await driver.getCurrentUrl();
      if (!currentUrl.includes('school.programmers.co.kr')) {
        return false;
      }

      const loginLinks = await driver.findElements(By.css('a[href*="sign_in"]'));
      return loginLinks.length === 0;
    }, 300000);

    await driver.wait(until.elementLocated(By.css('body')), 10000);

    console.log('Login appears to be complete.');
    console.log(`Current URL: ${await driver.getCurrentUrl()}`);
    console.log('You can keep using this Chrome window. Close it when you are done.');

    await driver.wait(async () => {
      const handles = await driver.getAllWindowHandles();
      return handles.length === 0;
    }, 86400000);
  } catch (error) {
    console.error('Attach/login flow did not complete.');
    console.error(error.message || error);
    throw error;
  } finally {
    try {
      await driver.quit();
    } catch {
    }
  }
}

main().catch(() => {
  process.exit(1);
});
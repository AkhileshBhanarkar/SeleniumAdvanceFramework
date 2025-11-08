package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends BaseTest {

    @Parameters({"browserWindowsUrl"})
    @Test(priority = 1)
    public void newTabTest(String browserWindowsUrl) {
        try {
            logInfo("Starting newTabTest");

            logInfo("Navigating to URL: " + browserWindowsUrl);
            driver.get(browserWindowsUrl);
            logPass("Successfully navigated to URL: " + browserWindowsUrl);

            logInfo("Clicking on the 'New Tab' button");
            browserWindowsPage.clickOnNewTabButton();
            logPass("'New Tab' button clicked successfully");

            logInfo("Fetching text from the new tab/window");
            String windowText = browserWindowsPage.getTextFromNewWindow();

            String expectedText = "This is a sample page";
            if (windowText.equals(expectedText)) {
                logPass("Verified window text: [" + windowText + "]");
            } else {
                logFail("Window text verification failed. Expected: [" + expectedText + "] but found: [" + windowText + "]");
                Assert.fail("Window text mismatch!");
            }

            logPass("New tab/window content validation completed successfully");
        } catch (Throwable t) {
            logFail("Test case failed due to an exception: " + t.getMessage());
            throw t;
        }
    }

    @Parameters({"browserWindowsUrl"})
    @Test(priority = 2)
    public void newWindowTest(String browserWindowsUrl) {
        try {
            logInfo("Starting newWindowTest");

            logInfo("Navigating to URL: " + browserWindowsUrl);
            driver.get(browserWindowsUrl);
            logPass("Successfully navigated to URL: " + browserWindowsUrl);

            logInfo("Clicking on the 'New Window' button");
            browserWindowsPage.clickOnNewWindowButton();
            logPass("'New Window' button clicked successfully");

            logInfo("Fetching text from the new window");
            String windowText = browserWindowsPage.getTextFromNewWindow();

            String expectedText = "This is a sample page";
            if (windowText.equals(expectedText)) {
                logPass("Verified window text: [" + windowText + "]");
            } else {
                logFail("Window text verification failed. Expected: [" + expectedText + "] but found: [" + windowText + "]");
                Assert.fail("Window text mismatch!");
            }

            logPass("New window content validation completed successfully");
        } catch (Throwable t) {
            logFail("Test case failed due to an exception: " + t.getMessage());
            throw t;
        }
    }
}
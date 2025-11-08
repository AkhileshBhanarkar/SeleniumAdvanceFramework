package tests;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Parameters({"framePageUrl"})
    @Test(priority = 1)
    public void frames1Test(String framePageUrl) {
        try {
            logInfo("Starting frames1Test");

            logInfo("Navigating to URL: " + framePageUrl);
            driver.get(framePageUrl);
            logPass("Successfully navigated to URL: " + framePageUrl);

            logInfo("Switching to Frame 1");
            framesPage.switchToFrame1();
            logPass("Successfully switched to Frame 1");

            logInfo("Getting heading text from frame");
            String text = framesPage.getHeadingText();

            String expectedText = "This is a sample page";
            if (text.contains(expectedText)) {
                logPass("Frame heading verified: [" + text + "]");
            } else {
                logFail("Frame heading verification failed. Expected to contain: [" + expectedText + "] but found: [" + text + "]");
                Assert.fail("Frame heading mismatch!");
            }

            logInfo("Switching back to default content");
            framesPage.switchToDefault();
            logPass("Successfully switched back to default content");

        } catch (Throwable t) {
            logFail("Test case failed due to an exception: " + t.getMessage());
            throw t;
        }
    }

    @Parameters({"framePageUrl"})
    @Test(priority = 2)
    public void frames2Test(String framePageUrl) {
        try {
            logInfo("Starting frames2Test");

            logInfo("Navigating to URL: " + framePageUrl);
            driver.get(framePageUrl);
            logPass("Successfully navigated to URL: " + framePageUrl);

            logInfo("Switching to Frame 2");
            framesPage.switchToFrame2();
            logPass("Successfully switched to Frame 2");

            logInfo("Getting heading text from frame");
            String text = framesPage.getHeadingText();

            String expectedText = "This is a sample page";
            if (text.equals(expectedText)) {
                logPass("Frame heading verified: [" + text + "]");
            } else {
                logFail("Frame heading verification failed. Expected: [" + expectedText + "] but found: [" + text + "]");
                Assert.fail("Frame heading mismatch!");
            }

            logInfo("Switching back to default content");
            framesPage.switchToDefault();
            logPass("Successfully switched back to default content");

        } catch (Throwable t) {
            logFail("Test case failed due to an exception: " + t.getMessage());
            throw t;
        }
    }
}
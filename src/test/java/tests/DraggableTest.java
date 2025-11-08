package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DraggableTest extends BaseTest {

    @Parameters({"dragDropPageUrl"})
    @Test(priority = 1)
    public void dragExample(String dragDropPageUrl) {
        try {
            logInfo("Starting dragExample test");

            logInfo("Navigating to URL: " + dragDropPageUrl);
            driver.get(dragDropPageUrl);
            logPass("Successfully navigated to URL: " + dragDropPageUrl);

            logInfo("Performing drag operation with offset (100, 50)");
            draggablePage.dragByOffset(100, 50);
            logPass("Drag operation completed successfully");

        } catch (Throwable t) {
            logFail("Test case failed due to an exception: " + t.getMessage());
            throw t;
        }
    }
}
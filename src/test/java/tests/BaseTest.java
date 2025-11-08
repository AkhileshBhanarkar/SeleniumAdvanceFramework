package tests;

import com.aventstack.extentreports.Status;
import driver.DriverManager;
import pages.BrowserWindowsPage;
import pages.DraggablePage;
import pages.FramesPage;
import pages.UploadDownloadPage;
import utils.ExtentManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static utils.ExtentManager.test;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(BaseTest.class);
    protected FramesPage framesPage;
    protected BrowserWindowsPage browserWindowsPage;
    protected DraggablePage draggablePage;
    protected UploadDownloadPage uploadDownloadPage;

    @Parameters({"browser", "headless", "implicit.wait"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser,
                      @Optional("false") String headless,
                      @Optional("30") String implicitWait) {

        DriverManager.initDriver(browser, Boolean.parseBoolean(headless),Integer.parseInt(implicitWait));

        driver = DriverManager.getDriver();
        driver.manage().window().maximize();

        // Initialize all page objects
        framesPage = new FramesPage(driver);
        browserWindowsPage = new BrowserWindowsPage(driver);
        draggablePage = new DraggablePage(driver);
        uploadDownloadPage = new UploadDownloadPage(driver);

        logger.info("Driver initialized with Browser=" + browser + ", Headless=" + headless);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        ExtentManager.flushReports();
        DriverManager.quitDriver();
    }

    /**
     * Logs an informational message to both logger and extent report
     * @param message Information message to be logged
     */
    protected void logInfo(String message) {
        logger.info(message);
        if (test != null) {
            test.get().log(Status.INFO, message);
        }
    }

    /**
     * Logs test pass message to both logger and extent report
     * @param message Success message to be logged
     */
    protected void logPass(String message) {
        logger.info("PASS: " + message);
        if (test != null) {
            test.get().log(Status.PASS, message);
        }
    }

    /**
     * Logs test failure message to both logger and extent report
     * @param message Failure message to be logged
     */
    protected void logFail(String message) {
        logger.error("FAIL: " + message);
        if (test != null) {
            test.get().log(Status.FAIL, message);
        }
    }
}

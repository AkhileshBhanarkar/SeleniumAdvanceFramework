package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.nio.file.Paths;

public class UploadDownloadTest extends BaseTest {

    @Parameters({"uploadDownloadUrl"})
    @Test(priority = 1)
    public void uploadDownload(String uploadDownloadUrl) {
        try {
            logInfo("Starting uploadDownload test");

            logInfo("Navigating to URL: " + uploadDownloadUrl);
            driver.get(uploadDownloadUrl);
            logPass("Successfully navigated to URL: " + uploadDownloadUrl);

            logInfo("Getting file path and preparing for upload");
            String file = Paths.get("src/test/resources/testfiles/sample.txt").toAbsolutePath().toString();
            logInfo("File path: " + file);

            logInfo("Uploading file");
            uploadDownloadPage.uploadFile(file);
            logPass("File uploaded successfully");

            logInfo("Initiating file download");
            uploadDownloadPage.clickDownload();
            logPass("File download initiated successfully");

        } catch (Throwable t) {
            logFail("Test case failed due to an exception: " + t.getMessage());
            throw t;
        }
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helpers;

/**
 * Represents the Upload and Download Page and provides methods for interacting with file upload and download.
 */
public class UploadDownloadPage {

    private final WebDriver driver;
    private final Helpers helpers;

    private final By uploadInput = By.id("uploadFile");
    private final By downloadButton = By.id("downloadButton");


    public UploadDownloadPage(WebDriver driver){
        this.driver = driver;
        this.helpers = new Helpers(driver);
    }

    /**
     * Uploads a file by specifying the absolute path.
     * @param absolutePath Absolute path of the file to upload.
     */
    public void uploadFile(String absolutePath){
        helpers.waitForElementToBeVisible(uploadInput,10);
        helpers.scrollToElement(uploadInput);
        helpers.sendKeys(uploadInput, absolutePath);
    }

    /**
     * Clicks the download button to download a file.
     */
    public void clickDownload(){
        helpers.waitForElementToBeVisible(downloadButton,10);
        helpers.scrollToElement(downloadButton);
        helpers.click(downloadButton);
    }
}
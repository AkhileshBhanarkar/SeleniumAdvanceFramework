package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helpers;

/**
 * Represents the Frames Page and provides methods for interacting with frames.
 */
public class FramesPage {

    private final WebDriver driver;
    private final Helpers helpers;


    private final By frame1 = By.id("frame1");
    private final By frame2 = By.id("frame2");
    private final By sampleHeading = By.id("sampleHeading");

    public FramesPage(WebDriver driver){
        this.driver = driver;
        this.helpers = new Helpers(driver);
    }

    /**
     * Switches to the first frame on the page.
     */
    public void switchToFrame1(){
        helpers.waitForElementToBeVisible(frame1,10);
        helpers.scrollToElement(frame1);
        driver.switchTo().frame(driver.findElement(frame1));
    }

    /**
     * Switches to the second frame on the page.
     */
    public void switchToFrame2(){
        helpers.waitForElementToBeVisible(frame2,10);
        helpers.scrollToElement(frame2);
        driver.switchTo().frame(driver.findElement(frame2));
    }

    /**
     * Retrieves the text inside the frame.
     * @return The text of the heading element inside the frame.
     */
    public String getHeadingText(){
        helpers.waitForElementToBeVisible(sampleHeading,10);
        helpers.scrollToElement(sampleHeading);
        return driver.findElement(sampleHeading).getText();
    }

    /**
     * Switches back to the default content from a frame.
     */
    public void switchToDefault(){
        driver.switchTo().defaultContent();
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helpers;

/**
 * Represents the Browser Windows Page and provides methods to handle window and tab interactions.
 */
public class BrowserWindowsPage {

    private final WebDriver driver;
    private final Helpers helpers;

    private final By newTabButton = By.id("tabButton");
    private final By newWindowButton = By.id("windowButton");
    private final By sampleHeading = By.id("sampleHeading");

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers(driver);
    }

    /**
     * Clicks on the "New Tab" button to open a new tab.
     */
    public void clickOnNewTabButton() {
        helpers.waitForElementToBeVisible(newTabButton,10);
        helpers.scrollToElement(newTabButton);
        helpers.click(newTabButton);
    }

    /**
     * Clicks on the "New Window" button to open a new window.
     */
    public void clickOnNewWindowButton() {
        helpers.waitForElementToBeVisible(newWindowButton,10);
        helpers.scrollToElement(newWindowButton);
        helpers.click(newWindowButton);
    }

    /**
     * Retrieves text from a newly opened window.
     * @return Text content from the new window.
     */
    public String getTextFromNewWindow(){
        helpers.windowSwitcher();
        helpers.waitForElementToBeVisible(sampleHeading,10);
        return driver.findElement(sampleHeading).getText();
    }
}
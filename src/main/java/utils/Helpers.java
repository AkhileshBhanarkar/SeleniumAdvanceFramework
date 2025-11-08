package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

/**
 * Provides utility methods to simplify and abstract common WebDriver operations.
 */
public class Helpers {
    private final WebDriver driver;

    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waits for an element to be visible and returns it (using By locator)
     * @param byLocator By object used to find the element
     * @param timeoutInSeconds Maximum time to wait for the element
     */
    public WebElement waitForElementToBeVisible(By byLocator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }

    /**
     * Clicks on an element, using a By locator
     * @param byLocator By locator of the element to click
     */
    public void click(By byLocator) {
        WebElement element = driver.findElement(byLocator);
        element.click();
    }

    /**
     * Sends input keys to an element, using a By locator
     * @param byLocator By locator of the element where keys will be sent
     * @param value     String value to send
     */
    public void sendKeys(By byLocator, String value) {
        WebElement element = driver.findElement(byLocator);
        element.sendKeys(value);
    }

    /**
     * Scrolls to an element using a By locator
     * @param byLocator By locator of the element to scroll to
     */
    public void scrollToElement(By byLocator) {
        WebElement element = driver.findElement(byLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Switches the WebDriver's window context to a child window.
     * If multiple windows are present, it switches to the first one that is not the parent window.
     */
    public void windowSwitcher() {
        String parent = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

//        Iterator<String> iterator = handles.iterator();
////        String parent = iterator.next();
//        windowName = iterator.next();
//        driver.switchTo().window(windowName);

        for (String h : handles) {
            if (!h.equals(parent)) {
                driver.switchTo().window(h);
            }
        }
    }

}

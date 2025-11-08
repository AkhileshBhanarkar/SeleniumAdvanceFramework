package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Helpers;

/**
 * Represents the Draggable Page and provides methods for interacting with it.
 */
public class DraggablePage {

    private final WebDriver driver;
    private final Helpers helpers;

    private final By dragBox = By.id("dragBox");

    public DraggablePage(WebDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers(driver);
    }

    /**
     * Drags an element by the specified offset (x, y).
     * @param x Horizontal offset to drag.
     * @param y Vertical offset to drag.
     */
    public void dragByOffset(int x, int y){
        helpers.waitForElementToBeVisible(dragBox,10);
        helpers.scrollToElement(dragBox);
        WebElement elem = driver.findElement(dragBox);
        new Actions(driver).dragAndDropBy(elem, x, y).perform();
    }

}
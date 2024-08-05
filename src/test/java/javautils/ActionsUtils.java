package javautils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {
    private WebDriver driver;
    private Actions actions;

    public ActionsUtils(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // Click an element
    public void click(WebElement element) {
        actions.moveToElement(element).click().perform();
    }

    // Double-click an element
    public void doubleClick(WebElement element) {
        actions.moveToElement(element).doubleClick().perform();
    }

    // Right-click (context-click) an element
    public void rightClick(WebElement element) {
        actions.moveToElement(element).contextClick().perform();
    }

    // Hover over an element
    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }

    // Drag and drop from source to target element
    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    // Drag and drop by offset
    public void dragAndDropBy(WebElement source, int xOffset, int yOffset) {
        actions.dragAndDropBy(source, xOffset, yOffset).perform();
    }

    // Click and hold an element
    public void clickAndHold(WebElement element) {
        actions.clickAndHold(element).perform();
    }

    // Release the mouse button
    public void release(WebElement element) {
        actions.release(element).perform();
    }

    // Send keys to an element
    public void sendKeys(WebElement element, String keys) {
        actions.moveToElement(element).sendKeys(keys).perform();
    }

    // Perform a sequence of actions
    public void performActionSequence(WebElement element) {
        actions.moveToElement(element).click().sendKeys("Some text").doubleClick().perform();
    }

    // Scroll to element
    public void scrollToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    // Scroll by offset
    public void scrollByOffset(int xOffset, int yOffset) {
        actions.moveByOffset(xOffset, yOffset).perform();
    }

    // Release all actions
    public void releaseAll() {
        actions.release().perform();
    }

    // Custom action chain
    public void customActionChain(WebElement element) {
        actions.moveToElement(element)
                .clickAndHold()
                .moveByOffset(100, 0)
                .release()
                .perform();
    }
}

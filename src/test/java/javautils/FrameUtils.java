package javautils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameUtils {
	private WebDriver driver;

	public FrameUtils(WebDriver driver) {
		this.driver = driver;
	}

	// Switch to a frame by its index
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// Switch to a frame by its name or ID
	public void switchToFrameByNameOrId(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// Switch to a frame by its WebElement
	public void switchToFrameByElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Switch to a frame by its locator
	public void switchToFrameByLocator(By locator) {
		WebElement frameElement = driver.findElement(locator);
		driver.switchTo().frame(frameElement);
	}

	// Switch back to the main content from a frame
	public void switchToMainContent() {
		driver.switchTo().defaultContent();
	}

	// Switch to the parent frame
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	// Check if a frame exists by its locator
	public boolean isFramePresent(By locator) {
		return !driver.findElements(locator).isEmpty();
	}
}

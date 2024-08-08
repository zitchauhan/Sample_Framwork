package javautils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowUtils {
	private WebDriver driver;

	public WindowUtils(WebDriver driver) {
		this.driver = driver;
	}

	// Switch to a window by its title
	public void switchToWindowByTitle(String windowTitle) {
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equals(windowTitle)) {
				return;
			}
		}
		driver.switchTo().window(currentWindow); // Switch back if title not found
		throw new RuntimeException("Window with title '" + windowTitle + "' not found.");
	}

	// Switch to a window by its handle
	public void switchToWindowByHandle(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	// Switch to a window by its index
	public void switchToWindowByIndex(int index) {
		Set<String> allWindows = driver.getWindowHandles();
		if (index < 0 || index >= allWindows.size()) {
			throw new IndexOutOfBoundsException("Invalid window index: " + index);
		}

		int i = 0;
		for (String window : allWindows) {
			if (i == index) {
				driver.switchTo().window(window);
				return;
			}
			i++;
		}
	}

	// Get the handle of the current window
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	// Close the current window and switch to the main window
	public void closeCurrentWindowAndSwitchToMain() {
		String mainWindow = driver.getWindowHandles().iterator().next();
		driver.close();
		driver.switchTo().window(mainWindow);
	}

	// Close all windows except the main window
	public void closeAllWindowsExceptMain() {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}

	// Get all window handles
	public Set<String> getAllWindowHandles() {
		return driver.getWindowHandles();
	}
}

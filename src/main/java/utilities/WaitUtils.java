// src/main/java/utilities/WaitUtils.java
package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 10; // default timeout in seconds

    // Wait for an element to be visible
    public static void waitForVisibility(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for an element to be clickable
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
    	 new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Wait for an element to be invisible
    public static void waitForInvisibility(WebDriver driver, WebElement element) {
    	 new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    // Wait for a URL to contain a specific string
    public static void waitForUrlContains(WebDriver driver, String partialUrl) {
    	 new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.urlContains(partialUrl));
    }
 // Set implicit wait
    public static void setImplicitWait(WebDriver driver, Duration duration) {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(duration);
        } else {
            throw new RuntimeException("WebDriver is not initialized.");
        }
    }
    // Additional utility methods can be added as needed
}

package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

	public static String takeScreenshot(WebDriver driver, String testName) {
		// Create a timestamp for uniqueness
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		// Define the path to save the screenshot
		String fileName = testName + "_" + timestamp + ".png";

		System.out.println("User directory: " + System.getProperty("user.dir"));

		String screenshotPath = System.getProperty("user.dir") + "/target/screenshots/" + fileName;

		// Create the screenshots directory if it does not exist
		File screenshotDir = new File(System.getProperty("user.dir") + "/target/screenshots");
		System.out.println("Screenshot directory: " + screenshotDir);
		System.out.println("Screenshot path: " + screenshotPath);

		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs();
		}

		// Capture the screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshotFile, new File(screenshotPath));
			System.out.println("Screenshot saved at: " + screenshotPath);
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}

		// Return the path of the screenshot
		return screenshotPath;
	}
}

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

	public static String takeScreenshot(WebDriver driver, String testName, boolean isFailed) {
		// Load configuration properties
		String captureScreenShot = ConfigReader.getProperty("CaptureScreenShot");
		String captureOnlyFail = ConfigReader.getProperty("CaptureOnlyFAIL");

		// Determine if screenshot should be taken
		if (captureScreenShot.equalsIgnoreCase("Yes") && (!captureOnlyFail.equalsIgnoreCase("Yes") || isFailed)) {
			// Create a timestamp for uniqueness
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

			// Define the result status for the file name
			String resultStatus = isFailed ? "failed" : "passed";

			// Define the path to save the screenshot
			String fileName = testName + "_" + resultStatus + "_" + timestamp + ".png";
			String screenshotPath = System.getProperty("user.dir") + "/target/screenshots/" + fileName;

			// Create the screenshots directory if it does not exist
			File screenshotDir = new File(System.getProperty("user.dir") + "/target/screenshots");
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
		} else {
			System.out.println("Screenshot not captured as per configuration.");
			return null;
		}
	}
}

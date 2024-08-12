package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import io.cucumber.java.Scenario;

public class RetryManager {

	private static final boolean RETRY_ENABLED = Boolean.parseBoolean(ConfigReader.getProperty("retry.enabled"));
	private static final int MAX_RETRY_COUNT = Integer.parseInt(ConfigReader.getProperty("max.retry.count"));
	private static final String CAPTURE_ONLY_FAIL = ConfigReader.getProperty("CaptureOnlyFAIL");

	private static ThreadLocal<Integer> retryCount = ThreadLocal.withInitial(() -> 0);
	private static ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();

	public static void initializeTest(Scenario scenario) {
		ExtentTest test = ExtentReportManager.createTest(scenario.getName());
		currentTest.set(test);
	}

	public static void handleFailure(Scenario scenario) {
		ExtentTest test = currentTest.get();
		int currentRetryCount = retryCount.get();

		if (scenario.isFailed()) {
			// Capture screenshot only if required by configuration
			String screenshotPath = ScreenshotUtil.takeScreenshot(BaseClass.getDriver(), scenario.getName(), true);
			if (screenshotPath != null) {
				test.log(Status.FAIL, "Scenario failed. Attempt: " + currentRetryCount + ". Screenshot: "
						+ test.addScreenCaptureFromPath(screenshotPath));
			} else {
				test.log(Status.FAIL, "Scenario failed. Attempt: " + currentRetryCount);
			}

			if (RETRY_ENABLED && currentRetryCount < MAX_RETRY_COUNT) {
				retryCount.set(currentRetryCount + 1);
				System.out.println("Retrying scenario: " + scenario.getName() + " Attempt: " + retryCount.get());
			} else {
				test.log(Status.FAIL, "Scenario failed after maximum retries.");
				retryCount.set(0);
				System.out.println("Failed after maximum retries: " + scenario.getName());
			}
		} else {
			if (CAPTURE_ONLY_FAIL.equalsIgnoreCase("No")) 
				
				{
				// Capture screenshot for passed scenarios if the config allows
				String screenshotPath = ScreenshotUtil.takeScreenshot(BaseClass.getDriver(), scenario.getName(), false);
				if (screenshotPath != null) 
				{
					test.log(Status.PASS,
							"Scenario passed. Screenshot: " + test.addScreenCaptureFromPath(screenshotPath));
				} else 
				
				{
					test.log(Status.PASS, "Scenario passed");
				}
			} else {
				test.log(Status.PASS, "Scenario passed");
			}
			retryCount.set(0);
		}

		ExtentReportManager.flushReports();
	}
}

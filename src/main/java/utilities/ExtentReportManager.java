package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseClass;

public class ExtentReportManager {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

	// Singleton pattern to create or return the ExtentReports instance
	public static ExtentReports getReportInstance() {
		if (extent == null) {
			synchronized (ExtentReportManager.class) {
				if (extent == null) {
					String environment = BaseClass.getProperty("environment"); // e.g., "dev", "qa", "prod"
					String reportPath = "target/extent-reports/" + environment + "/";
					new File(reportPath).mkdirs(); // Create directory if it does not exist
					String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
					String reportName = "Test-Automation-Report_" + timestamp + ".html";
					ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath + reportName);
					extent = new ExtentReports();
					extent.attachReporter(reporter);

					extent.setSystemInfo("OS", "Windows");
					extent.setSystemInfo("TesterName", "Automation");
					extent.setSystemInfo("Environment", environment);
					extent.setSystemInfo("OS", System.getProperty("os.name") + " " + System.getProperty("os.version"));
					extent.setSystemInfo("Java Version", System.getProperty("java.version"));
					extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));

				}
			}
		}
		return extent;
	}

	// Create a test instance and store it in a thread-local variable
	public static ExtentTest createTest(String testName) {
		ExtentReports extent = getReportInstance();
		ExtentTest test = extent.createTest(testName);
		testThreadLocal.set(test);
		return test;
	}

	// Retrieve the current thread's ExtentTest instance
	public static ExtentTest getTest() {
		return testThreadLocal.get();
	}

	// Finalize and flush the report
	public static void flushReports() {
		if (extent != null) {
			extent.flush();
		}
	}
}

package runners;

import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigReader;
import utilities.ExtentReportManager;

@CucumberOptions(features = "src/test/resources/features", glue = 

		{ "stepDefinitions", "hooks" }, plugin = 
		
		{ 
		"pretty",
		"html:target/cucumber-reports/cucumber-reports.html",
		"json:target/cucumber-reports/cucumber.json" 
		}, tags = "@apple")
//@Listeners(RetryListener.class) // Apply retry listener
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider
	public Object[][] scenarios() {
		boolean parallelExecution = ConfigReader.getBooleanProperty("parallelExecution");
		if (parallelExecution) {
			System.out.println("Parallel execution is enabled.");
			return super.scenarios(); // Return scenarios for parallel execution
		} else {
			System.out.println("Parallel execution is disabled.");
			return super.scenarios(); // Return scenarios for sequential execution
		}
	}

}

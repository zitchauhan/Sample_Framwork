package hooks;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.RetryManager;
import utilities.ConfigReader;

public class DriverHooks {
    // Fetch configurations
    private static final int MAX_RETRY_COUNT = Integer.parseInt(ConfigReader.getProperty("max.retry.count"));
    private static final boolean RETRY_ENABLED = Boolean.parseBoolean(ConfigReader.getProperty("retry.enabled"));
    private static ThreadLocal<Integer> retryCount = ThreadLocal.withInitial(() -> 0);
    private static ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {
        // Initialize WebDriver
        WebDriver driver = BaseClass.getDriver();
        System.out.println("WebDriver initialized: " + driver);

        // Setup before each scenario
       // ConfigReader
        TestSetup.setup();

        // Initialize test report for the scenario
        RetryManager.initializeTest(scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        // Handle failure and retries
        RetryManager.handleFailure(scenario);
        
        // Close WebDriver and perform cleanup
        BaseClass.quitDriver();
    }
}

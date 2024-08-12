package hooks;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.RetryManager;
import utilities.TestNGXmlGenerator;

public class DriverHooks 

	{

	@Before
	public void setUp(Scenario scenario) 
	
	{
		// Initialize WebDriver based on the browser specified in the config file
		WebDriver driver = BaseClass.getDriver();
		System.out.println("WebDriver initialized: " + driver);

		// Setup configuration and generate TestNG XML if required
		// setupConfiguration();

		// Initialize the test report for the scenario
		RetryManager.initializeTest(scenario);
	}

	@After
	public void tearDown(Scenario scenario) 
	
	{
		// Handle retries and failures, including screenshot capture
		RetryManager.handleFailure(scenario);

		// Quit WebDriver and perform cleanup
		BaseClass.quitDriver();
	}

	private void setupConfiguration() {
		Properties properties = new Properties();
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config/config.properties")) 
		
		{
			if (inputStream == null) 
			
			{
				throw new RuntimeException("Property file 'config/config.properties' not found in the classpath");
			}
			properties.load(inputStream);

			// Generate the TestNG XML file based on the properties
			// TestNGXmlGenerator.generateTestNGXml();

		} catch (IOException e) 
		
		{
			e.printStackTrace();
			
			throw new RuntimeException("Failed to load properties file", e);
		}
	}

}

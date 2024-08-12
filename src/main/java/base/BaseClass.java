package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseClass {

	// ThreadLocal to handle WebDriver instances in a thread-safe manner
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// Private constructor to prevent instantiation
	private BaseClass() {

	}

	// Method to get WebDriver instance
	public static WebDriver getDriver() 
	
	{
		if (driver.get() == null) 
		{
			synchronized (BaseClass.class) 
				{
				if (driver.get() == null) 
				
				{
					initializeDriver();
				}
			}
		}
		return driver.get();
	}

	// Method to initialize WebDriver based on browser type from the config
	private static void initializeDriver() {
		String browserName = ConfigReader.getProperty("browser", "chrome").toLowerCase();

		WebDriver newDriver;

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			newDriver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			newDriver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			newDriver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}
		newDriver.manage().window().maximize();
		newDriver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicitWait", "10"))));

		// Set the WebDriver instance to the ThreadLocal
		driver.set(newDriver);

		/*
		 * newDriver.manage().window().maximize();
		 * newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * driver.set(newDriver);
		 */ }

	// Method to quit the WebDriver instance
	public static void quitDriver()
		{
		
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}

	// Method to get property values from config file using ConfigReader
	public static String getProperty(String key)
	{
		return ConfigReader.getProperty(key);
	}

	// Method to get integer property values
	public static int getIntProperty(String key) 
	{
		return ConfigReader.getIntProperty(key);
	}

	// Method to get boolean property values
	public static boolean getBooleanProperty(String key) 
	{
		return ConfigReader.getBooleanProperty(key);
	}
}

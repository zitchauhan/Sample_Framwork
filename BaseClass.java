// src/main/java/base/BaseClass.java
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException 
	
	{
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("src\\main\\java\\config\\config.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
		  
			WebDriverManager.chromedriver().setup();
		    
		    driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
		    WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
		    WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		} else {
		    throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}


		
		driver.manage().window().maximize();
		
		return driver;
	}

	public String getProperty(String key) 
	{
		return prop.getProperty(key);
	}
	
	public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
}}

package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class WebDriverSingleton {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            synchronized (WebDriverSingleton.class) {
                if (driver.get() == null) {
                    initializeDriver();
                }
            }
        }
        return driver.get();
    }

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
        newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.set(newDriver);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

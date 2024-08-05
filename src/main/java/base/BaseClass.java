package base;

import org.openqa.selenium.WebDriver;

import utilities.ConfigReader;

public class BaseClass {

    // Private constructor to prevent instantiation
    private BaseClass() {
    }

    // Method to get WebDriver instance from WebDriverSingleton
    public static WebDriver getDriver() {
        return WebDriverSingleton.getDriver();
    }

    // Method to quit the WebDriver instance
    public static void quitDriver() {
        WebDriverSingleton.quitDriver();
    }

    // Method to get property values from config file using ConfigReader
    public static String getProperty(String key) {
        return ConfigReader.getProperty(key);
    }

    // Method to get integer property values
    public static int getIntProperty(String key) {
        return ConfigReader.getIntProperty(key);
    }

    // Method to get boolean property values
    public static boolean getBooleanProperty(String key) {
        return ConfigReader.getBooleanProperty(key);
    }
}

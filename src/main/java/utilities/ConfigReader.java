package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties = new Properties();

	static {
		try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties")) {
			if (input == null) {
				throw new RuntimeException("Configuration file not found");
			}
			properties.load(input);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load configuration properties", e);
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public static int getIntProperty(String key) {
		String value = properties.getProperty(key);
		if (value == null) {
			throw new IllegalArgumentException("Property not found: " + key);
		}
		return Integer.parseInt(value);
	}

	public static boolean getBooleanProperty(String key) {
		String value = properties.getProperty(key);
		if (value == null) {
			throw new IllegalArgumentException("Property not found: " + key);
		}
		return Boolean.parseBoolean(value);
	}

	public static Properties getProperties() {
		return properties;
	}

}

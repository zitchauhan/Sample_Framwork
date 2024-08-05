package hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import utilities.TestNGXmlGenerator;

public class TestSetup {

	public static void setup() {
		Properties properties = new Properties();
		try (FileInputStream fis = new FileInputStream("src/main/resources/config/config.properties")) {
			properties.load(fis);
			TestNGXmlGenerator.generateTestNGXml(properties);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load properties file", e);
		}
	}
}

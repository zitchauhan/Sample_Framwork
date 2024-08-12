package utilities;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class TestingUtil {
	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(8080);
		Socket client = server.accept();
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		out.write("dfdawdadwawdw");

		// Test reading properties from the config file
		Properties properties = ConfigReader.getProperties(); // Get all properties
		String parallelExecution = properties.getProperty("parallelExecution");
		String threadCount = properties.getProperty("threadCount", "1");
		System.out.println("Parallel Execution: " + parallelExecution);
		System.out.println("Thread Count: " + threadCount);
		TestNGXmlGenerator.generateTestNGXml();

		System.out.println("genrated");

		try {
			// Example properties
			String environment = ConfigReader.getProperty("environment");
			String browser = ConfigReader.getProperty("browser");
			String url = ConfigReader.getProperty("url");
			// boolean parallelExecution =
			// ConfigReader.getBooleanProperty("parallelExecution");
			// int threadCount = ConfigReader.getIntProperty("threadCount");
			boolean retryEnabled = ConfigReader.getBooleanProperty("retry.enabled");
			int maxRetryCount = ConfigReader.getIntProperty("max.retry.count");

			// Print out the values to verify they are read correctly
			System.out.println("Environment: " + environment);
			System.out.println("Browser: " + browser);
			System.out.println("URL: " + url);
			System.out.println("Parallel Execution: " + parallelExecution);
			System.out.println("Thread Count: " + threadCount);
			System.out.println("Retry Enabled: " + retryEnabled);
			System.out.println("Max Retry Count: " + maxRetryCount);
		} catch (Exception e) {
			// Handle any exceptions that occur during property retrieval
			e.printStackTrace();
		}
	}
}

package utilities;
public class ConfigReaderTest {
    public static void main(String[] args) {
        // Test reading properties from the config file
        try {
            // Example properties
            String environment = ConfigReader.getProperty("environment");
            String browser = ConfigReader.getProperty("browser");
            String url = ConfigReader.getProperty("url");
            boolean parallelExecution = ConfigReader.getBooleanProperty("parallelExecution");
            int threadCount = ConfigReader.getIntProperty("threadCount");
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
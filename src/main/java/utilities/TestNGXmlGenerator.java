package utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class TestNGXmlGenerator {
    public static void generateTestNGXml(Properties properties) {
        boolean parallelExecution = Boolean.parseBoolean(properties.getProperty("parallelExecution", "false"));
        int threadCount = Integer.parseInt(properties.getProperty("threadCount", "1"));

        String parallelAttribute = parallelExecution ? "parallel=\"tests\"" : "";
        String threadCountAttribute = parallelExecution ? " thread-count=\"" + threadCount + "\"" : "";

        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                            "<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\">\n" +
                            "<suite name=\"Cucumber Test Suite\" " + parallelAttribute + threadCountAttribute + ">\n" +
                            "    <test name=\"Cucumber Tests\">\n" +
                            "        <classes>\n" +
                            "            <class name=\"runners.TestNGTestRunner\"/>\n" +
                            "        </classes>\n" +
                            "    </test>\n" +
                            "</suite>";

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/test/resources/testng.xml"))) {
            writer.write(xmlContent);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to write TestNG XML file", e);
        }
    }
}

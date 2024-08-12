package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class TestNGXmlGenerator {

	public static void generateTestNGXml() {
		Properties properties = ConfigReader.getProperties();
		String parallelExecution = properties.getProperty("parallelExecution");
		String threadCount = properties.getProperty("threadCount", "1");

		String xmlContent;

		if (Boolean.parseBoolean(parallelExecution)) {
			// Parallel execution is enabled
			xmlContent = String.format("<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">\n"
					+ "<suite name=\"TestSuite\" parallel=\"tests\" thread-count=\"%s\">\n" + "    <listeners>\n"
					+ "        <listener class-name=\"utilities.RetryListener\"/>\n" + "    </listeners>\n"
					+ "    <test name=\"Test1\">\n" + "        <classes>\n"
					+ "            <class name=\"runners.TestNGTestRunner\">\n" + "            </class>\n"
					+ "        </classes>\n" + "    </test>\n" + "</suite>", threadCount);
		} else {
			// Parallel execution is disabled
			xmlContent = "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">\n"
					+ "<suite name=\"TestSuite\">\n" + "    <listeners>\n"
					+ "        <listener class-name=\"utilities.RetryListener\"/>\n" + "    </listeners>\n"
					+ "    <test name=\"Test1\">\n" + "        <classes>\n"
					+ "            <class name=\"runners.TestNGTestRunner\">\n" + "                <methods>\n"
					+ "                    <include name=\"setUpClass\"/>\n"
					+ "                    <include name=\"runScenario\" invocation-count=\"0\"/>\n"
					+ "                    <include name=\"tearDownClass\"/>\n" + "                </methods>\n"
					+ "            </class>\n" + "        </classes>\n" + "    </test>\n" + "</suite>";
		}

		File file = new File("src/test/resources/testng.xml");
		try (FileWriter fileWriter = new FileWriter(file)) {
			fileWriter.write(xmlContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

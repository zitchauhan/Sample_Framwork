package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", 
glue = { "stepDefinitions", "hooks" },
plugin = { "pretty",
		"html:target/cucumber-reports/cucumber-reports.html", 
		"json:target/cucumber-reports/cucumber.json" }
//,tags = "@Smoke"
		)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}

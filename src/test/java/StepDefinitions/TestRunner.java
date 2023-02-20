package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features", 
		glue = { "StepDefinitions" }, 
		plugin= {"pretty", "html:target/htmlReport/cucumber.html", 
				"junit:target/JUnitReports/report.xml"},
		monochrome = true,
		tags="@smokeTest"
		)
public class TestRunner {

}

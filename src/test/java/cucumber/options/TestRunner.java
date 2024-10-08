package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature", plugin = {"pretty","json:target/cucumber-reports/Cucumber.json",
		"html:target/cucumber-reports/Cucumber.html" }, glue = { "stepdefenation" }, tags = "@addplace2")
public class TestRunner {

}

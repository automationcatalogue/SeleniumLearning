package utilities;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\AaradhyaVashisht\\git\\SeleniumLearning\\src\\features\\DemoWebShop.feature",
		glue = {"stepDefinitions"},
		tags = "@DemoWebShop",
		dryRun = false,
		monochrome = true,
		plugin={"pretty","html:test-outputs","json:target/json-report","junit:target/cucumber-xml"}
)
		
public class TestRunner {

	
}

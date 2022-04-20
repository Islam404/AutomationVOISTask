package cucumberOptions;

import base.TestBase;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/RestAssured.feature", glue = "RestAssuredStepDefinition",tags="@RestAssured", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class RestAssuredRunner extends AbstractTestNGCucumberTests {

}
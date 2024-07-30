package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions", "base"},
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@AddItem")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}

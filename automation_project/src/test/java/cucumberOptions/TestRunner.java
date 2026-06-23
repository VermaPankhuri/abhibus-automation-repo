package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"hooks", "stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },
        monochrome = true,
        publish = true
)

public class TestRunner {

}
package Runner_Class;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = "src/test/resources/com.luma.bdd.qa.FeatureFile",
        glue = {"step_definition","com.bdd.hooks"},
        tags = "@LUMAShoppingCart",
        plugin = {"pretty", "html:target/site/cucumber-html", "json:target/cucumber1.json"}
)

public class RunnerTestNg extends AbstractTestNGCucumberTests {
}

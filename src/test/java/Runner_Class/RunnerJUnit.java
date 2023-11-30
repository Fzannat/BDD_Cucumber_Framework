package Runner_Class;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

                features = "src/test/resources/com.luma.bdd.qa.FeatureFile",
                glue = {"step_definition", "com.bdd.hooks"},
                tags = "@LUMALogin or @LUMACreateAnAccount or @LUMASearchProduct or @LUMAShoppingCart"

                )
public class RunnerJUnit {
}

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberReport.html", "json:target/testReport.json"},
        features = "/Users/nurgazyamanbaev/Desktop/ResedAsured/src/test/resources/features",
        glue = "step_definitions",
        tags = "@createTag",
        dryRun = false
)


public class CucumberRunner {
}

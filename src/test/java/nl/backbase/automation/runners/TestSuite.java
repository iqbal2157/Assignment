package nl.backbase.automation.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/",
        glue = {"nl.backbase.automation"}
)
@RunWith(CucumberWithSerenity.class)
public class TestSuite {
}

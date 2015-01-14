import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created with IntelliJ IDEA.
 * User: jmartins
 * Date: 14/01/15
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty",
        "html:target/test-reports",
        "json:target/test-reports/cucumber.json",
        "junit:target/test-reports/cucumber.xml"})

public class RunTest {
}

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class CucumberTest {
    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"C:\\my_projects\\Selenium-4-Fundamentals-Starter-master\\src\\test\\features\\LoginFeature.feature"},
            glue = {"C:\\my_projects\\Selenium-4-Fundamentals-Starter-master\\src\\test\\java\\StepDefinitionClass.java"},
            dryRun = true,
            monochrome = true,
            plugin = {"pretty"}
    )
    public class RunCucumberTest {

    }
}

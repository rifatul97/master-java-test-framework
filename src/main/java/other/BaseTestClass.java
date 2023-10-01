package other;

import helper.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestClass {
    protected WebDriver testWebDriver;

    @BeforeMethod
    public void initDriver() {
        testWebDriver = new DriverFactory().newChromeDriver().withHeadless().build();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        testWebDriver.quit();
    }
}

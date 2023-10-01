package helper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestClass {
    protected static WebDriver testWebDriver;

    @BeforeMethod
    public void setupDriver() throws InterruptedException {
        testWebDriver = new DriverFactory()
                            .newChromeDriver()
                            .withHeadless()
                            .build();
    }

    public void driverPause(int second) {
        try {
            Thread.sleep(second* 1000L);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @AfterMethod
    public void closeDriver() {
//        driver.close();
    }

}

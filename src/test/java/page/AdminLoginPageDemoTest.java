package page;

import helper.BaseTestClass;
import org.junit.jupiter.api.Test;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class AdminLoginPageDemoTest {


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = {"classpath:features/LoginFeature.feature"},
            glue = {"StepDefinitionClass"},
            dryRun = true,
            monochrome = true,
            plugin = {"pretty"}
    )
    public class RunCucumberTest {

    }


//    @Test(testName = "Login Button Functionality Test")
//    public void Test_1() {
//        var page = new AdminLoginPageDemo(testWebDriver);
//        page.enterEmail("admin@yourstore.com");
//        page.enterPassword("admin");
//        page.pressSubmit();
//        System.out.println(page.getTitle());;
//    }
//
////    @Test(testName = "Logout Functionality Test")
//    public void Test_2() {
//        var page = new AdminLoginPageDemo(testWebDriver);
//        page.enterEmail("admin@yourstore.com");
//        page.enterPassword("admin");
//        page.pressSubmit();
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        page.clickLogout();
//        System.out.println(page.getTitle());
//    }

}
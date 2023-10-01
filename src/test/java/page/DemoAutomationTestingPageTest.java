package page;

import helper.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static page.DemoAutomationTestingPage.GenderOption.MALE;
import static page.DemoAutomationTestingPage.HobbiesOption.Cricket;

public class DemoAutomationTestingPageTest extends BaseTestClass {

    @Test
    public void verifyRegisterPageAppears() {
        var page = DemoAutomationTestingPage.newPage(testWebDriver);
        page.clickOnSkipSign();
        Assert.assertTrue(page.checkIfRegisterTitleAppears());

        page.fillRegistrationForm(new DemoAutomationTestingPage.
                RegistrationForm("firstname", "lastname", "pass",
                "very long address", "myemail@gmail.com", "9999999999",
                MALE, Cricket, "English", "Python", "Australia",
                new DemoAutomationTestingPage.DateOfBirth(2017, 11, 1)));

        driverPause(5000);
    }


}
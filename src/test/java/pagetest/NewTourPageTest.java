package pagetest;

import helper.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.NewTourPage;

public class NewTourPageTest extends BaseTestClass {

    @Test
    public void testRegisterFunctionality() {
        final String testUsername = "pokede";
        final String testPassword = "passed";
        NewTourPage page = NewTourPage.newTourPage(testWebDriver);
        page.navigateTo(NewTourPage.NavigateOption.REGISTER);
        page.fillRegisterUserDetail(testUsername, testPassword);
        driverPause(2000);
        page.navigateTo(NewTourPage.NavigateOption.SIGN_ON);
        page.fillLoginUserDetail(testUsername, testPassword);
        driverPause(2000);
        String mes = page.getLoginSuccessfulResultMessage();
        Assert.assertTrue(page.getLoginSuccessfulResultMessage().contains("Successfully"));
    }


    @Test
    public void testLoginWithCorrectCredentials() {
        NewTourPage page = NewTourPage.newTourPage(testWebDriver);
        page.enterUsername("Admin");
        page.enterPassword("password");
        page.pressRegisterButton();

        Assert.assertTrue(page.getLoginSuccessfulResultMessage().contains("Successfully"));
    }

    @Test
    public void testLoginWithWrongCredentials() throws InterruptedException {
        NewTourPage page = NewTourPage.newTourPage(testWebDriver);
        page.enterUsername("Student");
        page.enterPassword("password");
        page.pressRegisterButton();

        Assert.assertNull(page.getLoginSuccessfulResultMessage());
    }

}

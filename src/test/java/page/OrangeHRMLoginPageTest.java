package page;

import helper.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMLoginPageTest extends BaseTestClass {

    @Test
    public void testLoginFunctionalityWithIncorrectCredentials() {
        OrangeHRMLoginPage page = OrangeHRMLoginPage.newPage(testWebDriver);
//        Assert.assertFalse(page.checkIfInValidCredentialsAppear());

        page.fillUsername("Admin");
        page.fillPasssword("password");
        page.clickLoginButton();

        Assert.assertTrue(page.checkIfInValidCredentialsAppear());
    }

    @Test
    public void testLoginFunctionalityWithCorrectCredentials() {
        OrangeHRMLoginPage page = OrangeHRMLoginPage.newPage(testWebDriver);

        page.fillUsername("Admin");
        page.fillPasssword("admin123");
        page.clickLoginButton();

        Assert.assertTrue(testWebDriver.getCurrentUrl().contains("dashboard"));
    }

}
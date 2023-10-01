package page;

import helper.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SauceDemoLoginPageTest extends BaseTestClass {

    @Test
    public void test_1() {
        var page = SauceDemoLoginPage.newPage(testWebDriver);

        page.enterUsername("standard_user");
        page.enterPassword("secret_sauce");
        page.clickLoginButton();

        Assert.assertTrue(page.getPageCurrentUrl().contains("inventory"));
    }

    @Test
    public void test_2() {
        var page = SauceDemoLoginPage.newPage(testWebDriver);

        page.enterUsername("non_standard_user");
        page.enterPassword("secret_sauce");
        page.clickLoginButton();

        Assert.assertTrue(page.checkIfLoginErrorAppear());
    }

    @Test
    public void test_3() {
        var page = SauceDemoLoginPage.newPage(testWebDriver);

        page.enterUsername("standard_user");
        page.clickLoginButton();

        Assert.assertTrue(page.checkIfLoginErrorAppear());
    }



}
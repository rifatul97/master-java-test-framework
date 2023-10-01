package page;

import helper.BaseTestClass;
import helper.JavaScriptUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoToolTipTest extends BaseTestClass {

    @Test
    public void test_1() {
        testWebDriver.get("https://www.facebook.com/");
        var actualToolTip = testWebDriver.findElement(By.xpath("//a[text()='Sign Up']"));
        JavaScriptUtil.scrollIntoView(actualToolTip, testWebDriver);
        String tooltip = actualToolTip.getAttribute("Title");
        Assert.assertEquals("Sign Up for Facebook", tooltip, "Tool tip verified");
    }

    @Test
    public void test_2() {
        testWebDriver.get("https://www.amazon.in/");
        var cookies = testWebDriver.manage().getCookies();
        for(var cookie : cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }
    }

}

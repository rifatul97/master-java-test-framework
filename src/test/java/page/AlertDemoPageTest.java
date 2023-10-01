package page;

import helper.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AlertDemoPageTest extends BaseTestClass {

    @Test
    public void test_1() {
        var page = AlertDemoPage.newPage(testWebDriver);
        page.navigateTo(AlertDemoPage.NAVIGATION_OPTION.ALERT_OK_N_CANCEL);
        page.clickCurrentTabButton();
        page.handleConfirmAlert(AlertDemoPage.ALERT_OPTION.CANCEL);
        System.out.println(page.getCurrentButtonName());
        System.out.println(page.getAlertResult());

    }

    @Test
    public void test_2() throws InterruptedException {
        var page = AlertDemoPage.newPage(testWebDriver);
        page.navigateTo(AlertDemoPage.NAVIGATION_OPTION.ALERT_OK_N_CANCEL);
        System.out.println(page.getCurrentButtonName());
        page.clickCurrentTabButton();
    }

}
package page;

import helper.BaseTestClass;
import org.testng.annotations.Test;

public class TwoPlugsPageTest extends BaseTestClass {

    @Test
    public void test_1() {
        var page = TwoPlugsPage.newPage(testWebDriver);
        page.selectNavOption(TwoPlugsPage.NavOption.ABOUT);
        page.readCurrentPageUrl();
    }

}
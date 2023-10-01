package pagetest;

import helper.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LetsKoDeitPage;

public class LetsKoDeitPageTest extends BaseTestClass {
    @Test
    public void checkRadioButtons() {
        var page = LetsKoDeitPage.newTourPage(testWebDriver);
        page.clickRadioButton(LetsKoDeitPage.CarOption.BMW);
        Assert.assertTrue(page.isRadioOptionSelected(LetsKoDeitPage.CarOption.BMW));
        Assert.assertFalse(page.isRadioOptionSelected(LetsKoDeitPage.CarOption.Honda));
    }

    @Test
    public void checkEnableDisableButtonFunctionality() {
        var page = LetsKoDeitPage.newTourPage(testWebDriver);
    }

    @Test
    public void selectClassExample() {
        var page = LetsKoDeitPage.newTourPage(testWebDriver);
        page.selectElementOnselectClassElement(LetsKoDeitPage.CarOption.Benz);
        Assert.assertTrue(page.checkIfElementSelectedOnSelectClass(LetsKoDeitPage.CarOption.Benz));
        Assert.assertFalse(page.checkIfElementSelectedOnSelectClass(LetsKoDeitPage.CarOption.Honda));
    }

    public void checkSelectMultipleExampleFunctionality() {
        var page = LetsKoDeitPage.newTourPage(testWebDriver);

    }

}

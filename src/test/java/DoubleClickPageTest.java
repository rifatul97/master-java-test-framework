import org.testng.Assert;
import org.testng.annotations.Test;
import other.BaseTestClass;
import other.DoubleClickPage;

public class DoubleClickPageTest extends BaseTestClass {

    @Test
    public void testMessageFunctionality()
    {
        var page = DoubleClickPage.newPage(testWebDriver);
        var getMessage = page.getClickButtonMessages();
        Assert.assertTrue(getMessage.isEmpty());
        page.clickDoubleClickButton();

        getMessage = page.getClickButtonMessages();
        Assert.assertTrue(getMessage.isPresent());
    }

    @Test
    public void testButtonsFunctionality()
    {
        var page = DoubleClickPage.newPage(testWebDriver);
        page.clickDoubleClickButton();
        page.clickRightClickButton();
        page.clickSingleClickButton();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        };
        System.out.println(page.getClickButtonMessages().get());
        Assert.assertEquals(page.getClickButtonMessages().get().size(), 3);
    }
}
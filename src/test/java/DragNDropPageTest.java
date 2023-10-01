import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import other.BaseTestClass;
import other.DragNDropPage;

import java.util.ArrayList;

public class DragNDropPageTest extends BaseTestClass {

    @Test
    public void test_1() throws InterruptedException {
        var page = DragNDropPage.newPage(testWebDriver);
        Actions action = new Actions(testWebDriver);
        var tt = testWebDriver.switchTo().frame(0);
        java.util.List<WebElement> liElements = testWebDriver.findElements(By.cssSelector("ul#gallery li.ui-widget-content.ui-corner-tr.ui-draggable.ui-draggable-handle"));

        java.util.List<WebElement> pics = new ArrayList<>();

        WebElement target = testWebDriver.findElement(By.cssSelector("div#trash"));
        System.out.println("number = " + liElements.size());

        liElements.forEach(gallery -> action.clickAndHold(gallery).moveToElement(target).release().build().perform());

        Thread.sleep(4000);
    }

}
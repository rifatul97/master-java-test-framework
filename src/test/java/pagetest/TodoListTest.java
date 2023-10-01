package pagetest;

import com.google.common.io.Files;
import com.sun.source.tree.AssertTree;
import helper.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TodoListTest {

    WebDriver driver;
    Actions actions;
    final String pageUrl = "https://todolist.james.am/";

    @BeforeTest
    public void setup() {
        driver = new DriverFactory().newChromeDriver().build();
        driver.get(pageUrl);
        actions = new Actions(driver);
    }

    @Test
    public void testIfInputWorks() throws InterruptedException {

        WebElement textField = driver.findElement(By.cssSelector("input[placeholder=\"What need's to be done?\"]"));

        actions.sendKeys(textField, "learn easy java");
        actions.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        List<WebElement> todoLists = driver.findElements(By.className("todo-list"));
        System.out.println(todoLists);

//        Assert.assertEquals(todoLists.size(), 1);
    }

    @AfterTest
    public void cleanUp() {
        System.out.println("closing..");
        driver.quit();
    }

}

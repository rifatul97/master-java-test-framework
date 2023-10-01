//package uitest.m4;
//
//import helper.DriverFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static helper.Pages.SAVINGS;
//
//public class SelectingTest {
//
//    @Test
//    public void selectingTest() {
//        WebDriver driver = new DriverFactory().get();
//        Actions actions = new Actions(driver);
//        driver.get(SAVINGS);
//
//        WebElement input = driver.findElement(By.id("deposit"));
//        actions.sendKeys(input, "100").perform();
//
//        WebElement dropDown = driver.findElement(By.id("period"));
//        Select select = new Select(dropDown);
//        select.selectByValue("6 months");
//        select.selectByVisibleText("1 Year");
//        select.selectByIndex(2);
//
//        WebElement result = driver.findElement(By.id("result"));
//        Assert.assertEquals(result.getText(), "After 2 Years you will earn $12.00 on your deposit");
//
//        driver.quit();
//    }
//
//}

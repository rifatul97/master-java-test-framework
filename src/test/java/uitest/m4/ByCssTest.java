//package uitest.m4;
//
//import helper.DemoHelper;
//import helper.DriverFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//
//import static helper.Pages.HOME;
//
//public class ByCssTest {
//
//    @Test
//    public void ByCssSelector() {
//        WebDriver driver = DriverFactory.newChromeDriver();
//        driver.get(HOME);
//
//        var datePicker = driver.findElement(By.cssSelector("input[type=date]"));
//        datePicker.sendKeys("10/12/2023");
//
//        DemoHelper.pause();
//        driver.quit();
//    }
//
//    @Test
//    public void ByCssSelector2() {
//        WebDriver driver = DriverFactory.newChromeDriver();
//        driver.get(HOME);
//        var checkBox =
//                driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
//        checkBox.click();
//
//        DemoHelper.pause();
//    }
//}

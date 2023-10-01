//package uitest.m4;
//
//import helper.DemoHelper;
//import helper.DriverFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Test;
//
//import static helper.Pages.HOME;
//
//public class NavigationTest {
//
//
//    @Test
//    public void webElementTest2() {
//        WebDriver driver = DriverFactory.newChromeDriver();
//        Actions actions = new Actions(driver);
//        driver.get(HOME);
//
//        WebElement checkBox =
//                driver.findElement(By.id("heard-about"));
//        actions.doubleClick(checkBox).perform();
//        actions.contextClick(checkBox).perform();
//
//        DemoHelper.pause();
//
//        WebElement textArea =
//                driver.findElement(By.id("textArea"));
//        textArea.sendKeys("Hello, World from selenium");
//
//        DemoHelper.pause();
//
//        driver.quit();
//    }
//
//
//    @Test
//    public void webElementTest() {
//        WebDriver driver = DriverFactory.newChromeDriver();
//        driver.get(HOME);
//
//        WebElement first = driver.findElement(By.id("firstName"));
//        first.sendKeys("DDD");
//        System.out.println(first.isDisplayed());
//        DemoHelper.pause();
//
//        WebElement button = driver.findElement(By.id("register"));
//        System.out.println(button.getText());
//        button.clear();
//
//        first.clear();
//        driver.quit();
//    }
//
//
//    @Test
//    public void basicNavigationTest() {
////        WebDriver driver = new ChromeDriver();
////        driver.manage().window().maximize();
////
////        driver.get(PREFIX + "index.html");
////        DemoHelper.pause();
////        driver.get(PREFIX + "savings.html");
////        DemoHelper.pause();;
////        driver.navigate().forward();
////
////        driver.navigate().refresh();
////
////        driver.quit();;
//    }
//
//}

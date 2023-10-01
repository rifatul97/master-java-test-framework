//package uitest.m4;
//
//import helper.DriverFactory;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class FirstScriptTest {
//
//    @Test
//    public void eightComponents() {
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = DriverFactory.newChromeDriver();
//
//        driver.get("https://google.com");
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//
//
//        String title = driver.getTitle();
////        assertEquals("Web form", title);
//        System.out.println("title = " + title);
////        Assert.assertTrue("Web form".equals(title));
////        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
//
////        WebElement textBox = driver.findElement(By.name("my-text"));
////        WebElement submitButton = driver.findElement(By.cssSelector("button"));
////
////        textBox.sendKeys("Selenium");
////        submitButton.click();
////
////        WebElement message = driver.findElement(By.id("message"));
////        String value = message.getText();
////        assertEquals("Received!", value);
//
//        driver.quit();
//    }
//
//}

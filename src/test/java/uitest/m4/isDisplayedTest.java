//        String txt = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
//        System.out.println(txt);
//
//        var rowList = driver.findElements(By.xpath("//table/tbody/tr"));
//        var columnList = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
//
//        System.out.println(rowList.size());
//
//        for(int r = 2; r < rowList.size(); r++) {
//            for (int c = 1; c < columnList.size(); c++) {
//                var data = driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td["+c+"]")).getText();
//                System.out.printf("data at r=%d c=%d is %s", r, c, data);
//            }
//        }

//package uitest.m4;
//
//import helper.DemoHelper;
//import helper.DriverFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static helper.Pages.HOME;
//
//public class isDisplayedTest {
//
//    @Test
//    public void isDisplayedErrorTest() {
//        WebDriver driver = new DriverFactory().newChromeDriver().get();
//        driver.get(HOME);
//        Actions actions = new Actions(driver);
//
//        List<WebElement> invalids = driver.findElements(By.className("invalid-feedback"));
//
//        actions.click(driver.findElement(By.id("register"))).perform();
//
//        boolean invalidTextAppears = false;
//        for (var invalid : invalids) {
//            if(!invalid.getText().equals("")) {
//                invalidTextAppears = true;
//            }
//        }
//
//        Assert.assertTrue(invalidTextAppears);
//        DemoHelper.pause();;
//
//        driver.quit();
//    }
//
//    @Test
//    public void isDisplayedNotErrorTest() {
//        WebDriver driver = new DriverFactory.newChromeDriver();
//        driver.get(HOME);
//        Actions actions = new Actions(driver);
//
//        Assert.assertFalse(checkIfValidTextAppears(driver));
//
//        actions.click(driver.findElement(By.id("register"))).perform();
//        Assert.assertTrue(checkIfValidTextAppears(driver));
//
//
//
//        List<WebElement> textFields = List.of(
//                driver.findElement(By.id("firstName")),
//                driver.findElement(By.id("lastName")),
//                driver.findElement(By.id("email")));
//
//
//
////        boolean webElementExists = textFields.stream().noneMatch(textfield -> textfield.getText().equals(""));
////
////        Assert.assertTrue(webElementExists);
//
//        actions.sendKeys(textFields.get(0), "Rifa").perform();;
//        actions.sendKeys(textFields.get(1), "Kari").perform();
//        actions.sendKeys(textFields.get(2), "email@gmail.com").perform();
//
//
//        DemoHelper.pause();
//
//        actions.click(driver.findElement(By.id("register"))).perform();
//
//
//        Assert.assertFalse(checkIfValidTextAppears(driver));
//
////        List<WebElement> invalids = driver.findElements(By.className("invalid-feedback"));
////        System.out.println("invalids = " + invalids.size());
////        for(var invalid : invalids) {
////            System.out.println("invalid text = " + invalid.getText());
////        }
////        Assert.assertEquals(invalids.size(), 0);
////
////        DemoHelper.pause();;
////
//        driver.close();
//    }
//
//    private boolean checkIfValidTextAppears(WebDriver driver) {
//        List<WebElement> invalids = driver.findElements(By.className("invalid-feedback"));
//        for (var invalid : invalids) {
//            if(!invalid.getText().equals("")) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//}

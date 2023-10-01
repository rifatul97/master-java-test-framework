package other;

import helper.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExceptionHandlingEx {
    public static void main(String[] args) {
        String url = "https://www.rediff.com/";
        var mydriver = new DriverFactory().newChromeDriver().withHeadless().buildWithURL(url);
//        WebDriver driver = WebDriverManager.chromedriver().getWebDriver();
//        WebElement divelement = mydriver.findElement(By.className("cellone"));
//        var insideelement = divelement.findElement(By.id("bseindex"));
//        System.out.println(insideelement.getText());
        var webelemtns = mydriver.findElement(By.cssSelector("ul.navbarul"));
        var li = webelemtns.findElements(By.tagName("li"));
        System.out.println(li.size());

        System.out.println("current url = " + mydriver.getCurrentUrl());
        mydriver.switchTo().frame("moneyiframe");
        System.out.println(mydriver.findElement(By.cssSelector("span#nseindex")).getText());

        mydriver.close();
    }
}

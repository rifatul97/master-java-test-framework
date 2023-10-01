package other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestFramePage {
    final private static String url = "https://the-internet.herokuapp.com/nested_frames";;

    private final WebDriver driver;

    private NestFramePage(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
//        PageFactory.initElements(driver, this);
//        driver.switchTo().frame("frame-top");
    }

    public static NestFramePage newPage(WebDriver testWebDriver) {
        return new NestFramePage(testWebDriver);
    }

    enum FRAME_OPTION {
        LEFT, MIDDLE, RIGHT, BOTTOM
    }

    public void switchFrameTo(String option) {
        var top = driver.switchTo().frame("frame-top");
        System.out.println("getting left");
        var left = top.switchTo().frame("frame-left");
        System.out.println("got you left");
        System.out.println(left.findElement(By.tagName("body")));
        System.out.println("getting right");
        var right = left.switchTo().frame("frame-right");
        System.out.println("got you right");
        System.out.println(right.findElement(By.tagName("body")));
        System.out.println("getting bottom");
        var bottom = driver.switchTo().frame("frame-bottom");
        System.out.println("got you bottom");
        System.out.println(bottom.findElement(By.tagName("body")));
//        System.out.println("getting frame of " + option.name().toLowerCase());
//        if(option.ordinal() > 3) {
//            driver.switchTo().frame("frame-top");
//            driver.switchTo().frame("frame-"+option.name().toLowerCase());
//        } else {
//            driver.switchTo().frame("frame-bottom");
//        }
    }

    public String getCurrentFrameText() {
        return driver.findElement(By.tagName("body")).getText();
    }


}

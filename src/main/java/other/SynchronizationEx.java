package other;

import com.google.common.base.Stopwatch;
import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static helper.WaitingUtils.waitUntilClickable;

public class SynchronizationEx {
    public static void main(String[] args) {
        var driver = new DriverFactory().newChromeDriver().withHeadless().build();
        driver.get("https://sellglobal.ebay.in/seller-center/home/");
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Stopwatch watch = Stopwatch.createStarted();
        try {

             waitUntilClickable(
                    driver,
                    By.linkText("START SELLING"))
                    .click();
        }
        catch (Exception e) {
            System.out.println("wat");
            System.out.println(e.getMessage());
            System.out.println("then...");
            assert watch != null;
        }
        System.out.println(watch.elapsed(TimeUnit.SECONDS) + "seconds");
        watch.stop();
        System.out.println("end");


        driver.quit();
    }
}

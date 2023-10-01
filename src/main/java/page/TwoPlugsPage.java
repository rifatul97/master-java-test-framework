package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TwoPlugsPage {

    private String url = "https://www.twoplugs.com/";

    private WebDriver driver;

    @FindBy(css = "body > div.wrapper > header > div > nav > ul > li ")
    private List<WebElement> navOption;

    public TwoPlugsPage(WebDriver webDriver) {
        this.driver = webDriver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public static TwoPlugsPage newPage(WebDriver driver) {
        return new TwoPlugsPage(driver);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("a.btn.border")).click();
    }

    enum NavOption {
        ABOUT, LIVE_POSTING, CONTACT, FAQ
    }

    public void selectNavOption(NavOption option) {
        System.out.println(navOption.size());
        navOption.get(option.ordinal()).click();
        var lis = driver.findElements(By.cssSelector("body > div.wrapper > header > div > nav > ul > li:nth-child(1) > a"));
        lis.forEach(l -> System.out.println(l.getText()));
    }

    public void clickJoinButton() {
        WebElement joinfff = driver.findElement(By.cssSelector("a.btn.green"));
    }

    public void readCurrentPageUrl() {
        System.out.println(driver.getCurrentUrl());
    }


}

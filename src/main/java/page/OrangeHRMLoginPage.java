package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRMLoginPage {

    private static final String pageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final WebDriver driver;

    OrangeHRMLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    public static OrangeHRMLoginPage newPage(WebDriver driver) {
        return new OrangeHRMLoginPage(driver);
    }

    public void fillUsername(String name) {
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(name);
        System.out.println(driver.findElement(By.name("username")).getText());
                driver.findElement(By.name("username")).sendKeys(name);
    }

    public void fillPasssword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("button[type='submit'][class*='oxd-button']")).click();
    }

    public boolean checkIfInValidCredentialsAppear() {
//        WebElement w = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]"));
        WebElement w = driver.findElement(By.cssSelector("div.oxd-alert--error"));

        System.out.println(w.getText());
        return w.isDisplayed();//        return driver.findElement(By.cssSelector("div.oxd-alert--error")).isDisplayed();
    }

}

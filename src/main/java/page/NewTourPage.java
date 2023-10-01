package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewTourPage {

    private static final String pageUrl = "https://demo.guru99.com/test/newtours/";
    private final WebDriver driver;

    NewTourPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    public static NewTourPage newTourPage(WebDriver driver) {
        return new NewTourPage(driver);
    }


    public void enterUsername(String name) {
        WebElement webElement = driver.findElement(By.cssSelector("input[name=\"userName\"]"));
        webElement.sendKeys(name);
    }

    public void enterPassword(String password) {
        WebElement webElement = driver.findElement(By.cssSelector("input[name=\"password\"]"));
        webElement.sendKeys(password);
    }

    public void pressRegisterButton() {
        WebElement webElement = driver.findElement(By.cssSelector("input[name=\"submit\"]"));
        webElement.click();
    }

    public void fillRegisterUserDetail(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmPassword")).sendKeys(password);
    }

    public void fillLoginUserDetail(String username, String password) {
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public enum NavigateOption {
        SIGN_ON, REGISTER;
        public String getName() {
            return this.name().replace("_", "-");
        }
    }

    public void navigateTo(NavigateOption option) {
        driver.findElement(By.linkText(option.getName())).click();
    }



    public String getLoginSuccessfulResultMessage() {
        try {
            WebElement h3Element = driver.findElement(By.cssSelector("h3"));
            return h3Element.getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

}

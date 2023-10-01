package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPageDemo {

    private WebDriver driver;
    private final String URL = "https://admin-demo.nopcommerce.com/login";

    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;


    public AdminLoginPageDemo(final WebDriver driver) {
        this.driver = driver;
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    public static AdminLoginPageDemo newPage(WebDriver driver) {
        return new AdminLoginPageDemo(driver);
    }

    public void enterEmail(String email) {
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void pressSubmit() {
        submitButton.click();
    }


    public String getTitle() {
        return driver.getTitle();
    }

    public void clickLogout() {
        var logoutButton = driver.findElement(By.cssSelector("#navbarText > ul > li:nth-child(3) > a"));
        logoutButton.click();
    }
}

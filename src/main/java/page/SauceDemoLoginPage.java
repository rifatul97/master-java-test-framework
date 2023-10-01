package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage {
    static final private String url = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement userNameTxtField;

    @FindBy(id = "password")
    private WebElement passwordTxtField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    private final String errorMsgContainer = "#login_button_container > div > form > div.error-message-container.error > h3";

    private WebDriver driver;

    private SauceDemoLoginPage(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    public static SauceDemoLoginPage newPage(WebDriver driver) {
        return new SauceDemoLoginPage(driver, url);
    }

    public void enterPassword(String pass) {
        passwordTxtField.sendKeys(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterUsername(String name) {
        userNameTxtField.sendKeys(name);
    }

    public String getPageCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean checkIfLoginErrorAppear() {
        var ele = driver.findElement(By.cssSelector(errorMsgContainer));
        return ele.isDisplayed();
    }

}

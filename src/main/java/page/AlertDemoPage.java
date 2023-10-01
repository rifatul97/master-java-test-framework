package page;

import helper.WaitingUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AlertDemoPage {

    private final static String pageUrl = "https://demo.automationtesting.in/Alerts.html";

    private final WebDriver driver;

    @FindBy(css = "body > div.container.center > div > div > div > div.tabpane.pullleft > ul > li")
    private List<WebElement> alertNav;

    @FindBy(css = "ul.nav.navbar-nav li")
    private List<WebElement> liElements;

    @FindBy(css = "header > nav > div > div.navbar-collapse.collapse.navbar-right > ul > li.dropdown.active.open > ul")
    private List<WebElement> wb;

    private NAVIGATION_OPTION option;

    private AlertDemoPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
        option = NAVIGATION_OPTION.ALERT_WITH_OK;
        System.out.println("init done!");
    }


    public static AlertDemoPage newPage(WebDriver driver) {
        return new AlertDemoPage(driver);
    }

    enum NAVIGATION_OPTION {
        ALERT_WITH_OK, ALERT_OK_N_CANCEL, ALERT_TEXTBOX;
    }

    public void navigateTo(NAVIGATION_OPTION option) {
        alertNav.get(option.ordinal()).click();
        this.option = NAVIGATION_OPTION.values()[option.ordinal()];
    }

    public String getCurrentButtonName() {
        return getCurrentTabButton(option).getText();
    }

    public String getAlertResult() {
        String path = (option == NAVIGATION_OPTION.ALERT_OK_N_CANCEL) ? "#demo" : "#demo1";
        return driver.findElement(By.cssSelector(path)).getText();
    }

    public void handleTextAlert(String message){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    enum ALERT_OPTION {
        OK, CANCEL
    }

    public void handlePromptAlert(String text, ALERT_OPTION option) {
        getAlert().sendKeys(text);
    }

    public void handleConfirmAlert(ALERT_OPTION option) {
        if (option == ALERT_OPTION.OK) {
            getAlert().accept();
        } else {
            getAlert().dismiss();
        }
    }

    public void handleAlert() {
        handleConfirmAlert(ALERT_OPTION.OK);
    }

    public void clickCurrentTabButton() {
        getCurrentTabButton(this.option).click();
    }

    private Alert getAlert() {
        return driver.switchTo().alert();
    }

    private WebElement getCurrentTabButton(NAVIGATION_OPTION option) {
        switch(option) {
            case ALERT_WITH_OK -> {
                return driver.findElement(By.cssSelector("#OKTab > button"));
            }
            case ALERT_OK_N_CANCEL -> {
                return driver.findElement(By.cssSelector("#CancelTab > button"));
            }
            default -> {
                return driver.findElement(By.cssSelector("#Textbox > button"));
            }
        }
    }

}
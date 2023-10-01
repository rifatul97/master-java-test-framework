package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewTourRegisterPage {

    private static final String pageUrl = "https://demo.guru99.com/test/newtours/register.php";
    private final WebDriver driver;

    NewTourRegisterPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    public static NewTourRegisterPage newTourPage(WebDriver driver) {
        return new NewTourRegisterPage(driver);
    }

    record ContactInfo(String firstName, String LastName, String Phone, String email) {};
    record MailingInfo(String Address, String city, String state, int postalCode, String country){}
    record UserInfo(String username, String password) {}



}

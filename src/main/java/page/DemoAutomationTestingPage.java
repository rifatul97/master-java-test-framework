package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import helper.WaitingUtils;

import static org.openqa.selenium.By.id;

public class DemoAutomationTestingPage {

    private final static String pageUrl = "https://demo.automationtesting.in/";

    private final WebDriver driver;

    @FindBy(id = "btn2")
    private WebElement skipSignIn;

    DemoAutomationTestingPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    public static DemoAutomationTestingPage newPage(WebDriver driver) {
        return new DemoAutomationTestingPage(driver);
    }

    public void clickOnSkipSign() {
        driver.findElement(id("btn2")).click();
    }

    public boolean checkIfRegisterTitleAppears() {
        return driver.findElement(By.cssSelector("h2")).getText().contains("Register");
    }

    enum GenderOption {
        MALE, FEMALE
    }

    enum HobbiesOption {
        Cricket, Movies, Hockey
    }

    record DateOfBirth(int year, int month, int day){};

    record RegistrationForm(String firstName, String lastName, String password, String address, String emailAddress,
                            String phone, GenderOption genderOption, HobbiesOption hobbySelection, String language,
                            String skill, String selectCountry, DateOfBirth dateOfBirth
                            ) {};

    public void fillEmail(String email) {
        driver.findElement(By.cssSelector("input[type='email']"))
                .sendKeys(email);
    }

    public void fillFirstAndLastName(String firstName, String lastName) {
        driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[ng-model=\"LastName\"]")).sendKeys(lastName);
    }

    public void fillAddress(String address) {
        driver.
                findElement(By.xpath("//textarea[@ng-model='Adress']"))
                .sendKeys("41-34 55555tt");
    }

    public void fillPhone(String phone) {
        driver.findElement(By.cssSelector("input[type='tel']")).sendKeys(phone);
    }

    public void fillPassword(String pass) {
        driver.findElements(By.cssSelector("input[type='password'")).forEach(webElement ->
                webElement.sendKeys(pass));
    }

    public void fillGenderOption(GenderOption option) {
        var radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        radioButtons.get(option.ordinal()).click();
    }

    public void fillHobbySelection(HobbiesOption options) {
        WaitingUtils.waitUntilClickable(driver, By.cssSelector("#checkbox" + options.ordinal()+1)).click();
    }

    public void fillSkillSelection(String skill) {
        new Select(driver.findElement(By.id("Skills"))).
                selectByIndex(0);
    }

    public void fillCountrySelection(String countryName) {
        WebElement multiSelectDropdown = driver.findElement(By.id("msdd"));

        // Click on the dropdown to open options
        multiSelectDropdown.click();

        // Initialize the Select class with the dropdown element
        Select select = new Select(multiSelectDropdown);

        select.selectByVisibleText("Arabic");
        select.selectByValue("English");

        select.getOptions().forEach(i -> System.out.println(i.getText()));

    }

    public void fillbirthFormSelection(DateOfBirth date) {

        new Select(driver.findElement(id("yearbox")))
                .selectByIndex(0);

        new Select(driver.findElement(By.cssSelector("input[ng-model=\"daybox\"]")))
                .selectByIndex(0);

        new Select(driver.findElement(id("daybox")))
                .selectByIndex(0);

    }

    public void fillLanguageSelection(String lang) {
        WebElement multiSelectDropdown = driver.findElement(By.id("msdd"));

        // Click on the dropdown to open options
        multiSelectDropdown.click();

        // Initialize the Select class with the dropdown element
        Select select = new Select(multiSelectDropdown);

        // Select one or more languages by value, visible text, or index
        select.selectByValue("Arabic");
    }

    public void fillRegistrationForm(RegistrationForm form) {
//        fillFirstAndLastName(form.firstName, form.lastName);
//        fillAddress(form.address);
//        fillEmail(form.emailAddress);
//        fillPhone(form.phone);
//        fillPassword(form.password());
//        fillGenderOption(form.genderOption);
//        fillHobbySelection(form.hobbySelection());
//        fillLanguageSelection(form.language);
//        fillSkillSelection(form.skill);
        fillCountrySelection(form.selectCountry);
//        fillbirthFormSelection(form.dateOfBirth);
    }

}

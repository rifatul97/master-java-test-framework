package page;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LetsKoDeitPage {

    private static final String pageUrl = "https://www.letskodeit.com/practice";
    private final WebDriver driver;

    LetsKoDeitPage(WebDriver driver) {
        this.driver = driver;
        driver.get(pageUrl);
    }

    public static LetsKoDeitPage newTourPage(WebDriver driver) {
        return new LetsKoDeitPage(driver);
    }

    public enum CarOption {
        BMW , Benz, Honda
    }

    public enum Option {
        YES, NO
    }

    public void clickRadioButton(CarOption option) {
        List<WebElement> webel = driver.findElements(By.cssSelector("input[type='radio'][name='cars']"));
        webel.get(option.ordinal()).click();
    }

    public boolean isRadioOptionSelected(CarOption option) {
        List<WebElement> webel = driver.findElements(By.cssSelector("input[type='radio'][name='cars']"));
        return webel.get(option.ordinal()).isSelected();
    }

    public void clickEnableDisableButton(boolean clickEnable) {
        WebElement enabledExampleDiv = driver.findElement(By.id("enabled-example-div"));
        List<WebElement> buttonsInsideDiv = enabledExampleDiv.findElements(By.cssSelector("input[type='submit'].btn-style.class2"));
        if (clickEnable) {
            buttonsInsideDiv.get(1).click();
        } else {
            buttonsInsideDiv.get(0).click();
        }
    }

    public boolean checkEnableButtonSelected(boolean isSelected) {
        WebElement enabledExampleDiv = driver.findElement(By.id("enabled-example-div"));
        List<WebElement> buttonsInsideDiv = enabledExampleDiv.findElements(By.cssSelector("input[type='submit'].btn-style.class2"));
        return buttonsInsideDiv.get(1).isSelected() == isSelected;
    }

    public void enterWordIntoEnableDisableTextField(String words) {
        WebElement textfield = driver.findElement(By.id("enabled-example-input"));
        textfield.sendKeys(words);
    }

    public boolean checkIfEnableDisableTextFieldIsEnabled() {
        WebElement textfield = driver.findElement(By.id("enabled-example-input"));
        return textfield.isEnabled();
    }

    public void selectElementOnselectClassElement(CarOption option) {
        WebElement selectElement = driver.findElement(By.id("carselect"));
        new Select(selectElement).selectByVisibleText(option.name());
    }

    public boolean checkIfElementSelectedOnSelectClass(CarOption option) {
        WebElement selectElement = driver.findElement(By.id("carselect"));
        String getCurrentSelectedText = new Select(selectElement)
                .getFirstSelectedOption().getText();
        return getCurrentSelectedText.equals(option.name());
    }

    public void selectElementsFromMultiClass(CarOption... options) {
        WebElement webElement = driver.findElement(By.id("multiple-select-example"));
        Select select = new Select(webElement);
    }


}

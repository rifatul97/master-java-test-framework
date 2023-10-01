package other;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DoubleClickPage {
    private final String url = "https://demoqa.com/buttons";

    private final WebDriver driver;
    private final Actions actions;

    @FindBy(id = "doubleClickBtn")
    private WebElement doublebutton;

    @FindBy(id = "rightClickBtn")
    private WebElement rightClickButton;

//    @FindBy(id = "LjNaK") <---- dynamic id
//    private WebElement dynamicButton;


    DoubleClickPage(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        System.out.println("yes");
    }

    public static DoubleClickPage newPage(WebDriver driver) {
        return new DoubleClickPage(driver);
    }


    public void clickRightClickButton() {
        actions.contextClick(rightClickButton).build().perform();
        System.out.println("right button clicked");
    }

    public void clickSingleClickButton() {
//        var ele = driver.findElement(By.xpath("//*[text()='Click Me']"));
//        actions.click(ele).perform();
        System.out.println("now clicking the single button!!");
        var button = driver.findElement(By.cssSelector("[id^='tHfNN']"));
        button.click();
        System.out.println("single button clicked");
    }

    public void clickDoubleClickButton() {
        actions.doubleClick(doublebutton).perform();
        System.out.println("double button clicked");
    }

    public Optional<List<String>> getClickButtonMessages() {
        System.out.println("getting click button messages");
        try {
            List<WebElement> webElements = driver.findElements(By.tagName("p"));
            System.out.println(webElements.size());
            return Optional.of(webElements.stream().map(WebElement::getText).collect(Collectors.toList()));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}

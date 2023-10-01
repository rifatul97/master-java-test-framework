package other;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDropPage {
    private static final String url = "https://jqueryui.com/droppable/#photo-manager";
    private final WebDriver driver;
    private Actions actions;

    private DragNDropPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(url);
        this.actions = new Actions(driver);
    }

    public static DragNDropPage newPage(WebDriver driver) {
        return new DragNDropPage(driver);
    }




}

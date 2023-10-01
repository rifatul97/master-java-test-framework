package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    public WebDriver chromeDriver() {
        return this.newChromeDriver().withHeadless().build();
    }

    enum DRIVER {
        CHROME("webdriver.chrome.driver", "chrome-driver.location");

        final String systemKey; final String driverLocation;

        DRIVER(String systemKey, String driverLocation) {
            this.systemKey = systemKey;
            this.driverLocation = driverLocation;
        }
    };

    private static WebDriver driver;
    private static ChromeOptions options = null;
    private DRIVER selected = null;
    private String url = null;

    public DriverFactory newChromeDriver() {
        selected = DRIVER.CHROME; return this;
    }

    public DriverFactory withHeadless() {
        switch (selected) {
            case CHROME -> {
                options = new ChromeOptions();
                options.addArguments("--headless");
                return this;
            }
            default -> { break; }
        }
        return this;
    }

    public WebDriver buildWithURL(String url) {
        this.url = url;
        return build();
    }

    public WebDriver build() {
        System.setProperty(selected.systemKey, ApplicationProperties.getValue(selected.driverLocation));
        switch (selected) {
            case CHROME -> {
                driver = options == null ? new ChromeDriver() : new ChromeDriver(options);
                break;
            }
            default -> { break; }
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if(url != null) {
            driver.get(url);
        }
        return driver;
    }

}

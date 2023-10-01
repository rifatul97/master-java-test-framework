package page;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

    @DataProvider(name = "searchDataSet")
    public Object[][] searchData() {
        Object[][] searchKeyWords = new Object [3] [2];

        searchKeyWords[0] [0] = "India"; searchKeyWords[0] [1] = "Qutab Minar";
        searchKeyWords[1] [0] = "Agra"; searchKeyWords[1] [1] = "Taj Mahal";
        searchKeyWords[2] [0] = "Hyderbad"; searchKeyWords[2] [1] = "Char Minar";

        return searchKeyWords;
    }

    @Test(dataProvider = "searchDataSet")
    public void GoogleSearchTC(String country, String monument) throws InterruptedException {

        var driver = new DriverFactory().newChromeDriver().build();

        driver.get("https://google.com/");

        var sBox = driver.findElement(By.name("q"));
        sBox.sendKeys(country + " " + monument);

        var sBoxBtn = driver.findElement(By.name("btnK"));
        sBoxBtn.click();

        Thread.sleep(2000);

        driver.quit();
    }


}

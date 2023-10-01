//package uitest.m4;
//
//import com.google.common.collect.HashBasedTable;
//import com.google.common.collect.Table;
//import helper.DriverFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static helper.Pages.SAVINGS;
//
//public class GetTableDataDemo {
//
//    @Test
//    public void scrapeTableData() {
//        WebDriver driver = DriverFactory.newChromeDriver();
//        driver.get(SAVINGS);
//
//        Table<Integer, Integer, String> tableObj
//                = HashBasedTable.create();
//
//        WebElement table = driver.findElement(By.id("rates"));
//        List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//        int rowIndex = 0;
//        int colIndex = 0;
//
//        for(WebElement row : rows) {
//            List<WebElement> cols = row.findElements(By.tagName("td"));
//            for (WebElement col : cols) {
//                tableObj.put(rowIndex, colIndex++, col.getText());
//            }
//            rowIndex++;
//            colIndex = 0;
//        }
//
//        System.out.println(tableObj);
//        System.out.println("Best rate: " + tableObj.get(1, 3));
//        driver.quit();
//    }
//
//}

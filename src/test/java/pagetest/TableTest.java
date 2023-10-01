package pagetest;

import helper.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableTest {

    final String url = "https://testautomationpractice.blogspot.com/";

    record BookTable(String BookName, String Author, String subject, int price) {
        @Override
        public String toString() {
            return String.format("{\n\tName: %s,\n\tAuthor: %s,\n\tSubject: %s,\n\tPrice: %d\n}", BookName(), Author(), subject(), price());
        }
    };

    @Test
    public void test_1() {
        WebDriver driver = new DriverFactory().newChromeDriver().withHeadless().build();
        driver.get(url);

        WebElement table = driver.findElement(By.tagName("table"));

        // check if table exist
        Assert.assertTrue(table.isDisplayed());

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // check if there are 7 rows
        Assert.assertEquals(rows.size(), 7);


        List<BookTable> books = new ArrayList<>();

        rows.subList(1, rows.size()).forEach(row -> {
            List<String> bookData = row.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();

            books.add(new BookTable(bookData.get(0), bookData.get(1), bookData.get(2), Integer.parseInt(bookData.get(3))));
        });


        books.forEach(book -> {
            System.out.println(book + ",");
        });

        int totalPrice = books.stream().map(book -> book.price).reduce(0, Integer::sum);

        Assert.assertEquals(totalPrice, 7100);


        driver.quit();
    }

    @Test
    public void test_2() {
        String productTableCssSelectorPath = "#productTable > tbody";

        WebDriver driver = new DriverFactory().newChromeDriver().withHeadless().build();
        driver.get(url);

        var tableBody = driver.findElement(By.cssSelector(productTableCssSelectorPath));

        var rows = tableBody.findElements(By.tagName("tr"));

        System.out.println(rows.size());

        driver.quit();

    }
}

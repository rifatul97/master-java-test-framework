import helper.BaseTestClass;
import helper.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.AdminLoginPageDemo;

public class StepDefinitionClass {

    private static WebDriver driver;
    private AdminLoginPageDemo page;

    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
        System.out.println("starting");
        driver =  new DriverFactory()
                .newChromeDriver()
                .withHeadless()
                .build();

        this.page = new AdminLoginPageDemo(driver);
    }

    @When("User Opens URL {string}")
    public void userOpensURL(String arg0) {
        driver.get(arg0);
    }

    @And("When User enters Email as {string} and Password as {string}")
    public void whenUserEntersEmailAsAndPasswordAs(String arg0, String arg1) {
        page.enterEmail(arg0);
        page.enterPassword(arg1);
    }

    @When("Click on Login")
    public void click_on_login() {
        page.pressSubmit();
    }

    @When("User click on Logout Button")
    public void user_click_on_logout_button() {
        page.clickLogout();
    }

    @Then("close Browser")
    public void close_browser() {
        driver.close();
    }

    @Then("Page Title should be {string}")
    public void pageTitleShouldBe(String arg0) {
        System.out.println(arg0);
//        Assert.assertEquals(arg0, "https://admin-demo.nopcommerce.com/admin/");
    }



}

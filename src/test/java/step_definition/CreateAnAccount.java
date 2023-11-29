package step_definition;

import com.luma.bdd.qa.Utilities.Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;

public class CreateAnAccount {
    public WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(1000));
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(1000);
    }

    @Given("user navigate to create an account page")
    public void user_navigate_to_create_an_account_page() {
        driver.findElement(By.xpath("//div[@class = 'panel header']//descendant::a[contains(text(), 'Create an Account')]")).click();

    }
    @Given("user clicked on createAnAccount button")
    public void user_clicked_on_create_an_account_button() throws InterruptedException {
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();
        Thread.sleep(1000);

    }
    @When("user entered all the below field")
    public void user_entered_all_the_below_field(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("firstname")).sendKeys(dataMap.get("firstName"));
        driver.findElement(By.id("lastname")).sendKeys(dataMap.get("lastName"));
        driver.findElement(By.id("email_address")).sendKeys(Util.generateEmailWithDateTimeStamp());
        driver.findElement(By.id("password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("password-confirmation")).sendKeys(dataMap.get("confirmPassword"));

    }
    @When("user entered all the below with duplicateEmail")
    public void user_entered_all_the_below_field_with_duplicate_email(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        driver.findElement(By.id("firstname")).sendKeys(dataMap.get("firstName"));
        driver.findElement(By.id("lastname")).sendKeys(dataMap.get("lastName"));
        driver.findElement(By.id("email_address")).sendKeys("f@gmal.com");
        driver.findElement(By.id("password")).sendKeys(dataMap.get("password"));
        driver.findElement(By.id("password-confirmation")).sendKeys(dataMap.get("confirmPassword"));

    }
    @Then("user Account gets created")
    public void user_account_gets_created() {
        String actualConfirmationText = driver.findElement(By.xpath(
                "//div[text() = 'Thank you for registering with Main Website Store.']")).getText();
        String expectedConfirmationText = "Thank you for registering with Main Website Store.";
        Assert.assertTrue(actualConfirmationText.contains(expectedConfirmationText));

    }

    @Then("user gets error massage for using duplicate email")
    public void user_gets_error_massage_for_using_duplicate_email() {
        String actualErrorMessage = driver.findElement(By.xpath(
                "//div[contains(text(),'There is already an account with this email address. If you are sure that it is your email address,')]")).getText();
        String expectedErrorMessage = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
    }


    @Then("user gets error messages for all required fields")
    public void user_gets_error_messages_for_all_required_fields() {
        String actualFirstNameErrorMessage = driver.findElement(By.id("firstname-error")).getText();
        String expectedFirstNameErrorMessage = "This is a required field.";
        String actualLastNameErrorMessage = driver.findElement(By.id("lastname-error")).getText();
        String expectedLastNameErrorMessage = "This is a required field.";
        String actualEmailAddressErrorMessage = driver.findElement(By.id("email_address-error")).getText();
        String expectedEmailAddressErrorMessage = "This is a required field.";
        String actualPasswordErrorMessage = driver.findElement(By.id("password-error")).getText();
        String expectedPasswordErrorMessage = "This is a required field.";
        String actualPasswordConfirmationErrorMessage = driver.findElement(By.id("password-confirmation-error")).getText();
        String expectedPasswordConfirmationErrorMessage = "This is a required field.";
        Assert.assertTrue(actualFirstNameErrorMessage.contains(expectedFirstNameErrorMessage) && actualLastNameErrorMessage.contains(expectedLastNameErrorMessage)
                && actualEmailAddressErrorMessage.contains(expectedEmailAddressErrorMessage) &&
                actualPasswordErrorMessage.contains(expectedPasswordErrorMessage)
                && actualPasswordConfirmationErrorMessage.contains(expectedPasswordConfirmationErrorMessage));

    }

    @After
    public void tearUp(){
        driver.quit();
    }


}

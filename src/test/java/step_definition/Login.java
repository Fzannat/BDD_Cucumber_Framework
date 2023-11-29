package step_definition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Login {
    public WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(1000));
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Given("user navigate to SignIn page")
    public void user_navigate_to_SignIn_page(){
        driver.findElement(By.xpath("//div[@class = 'panel header']//descendant::a[contains(text(), 'Sign In')]")).click();
    }
    @When("user entered valid email {string}")
    public void user_entered_valid_email(String emailText){
        driver.findElement(By.id("email")).sendKeys(emailText);

    }
    @And("user entered valid password {string}")
    public void user_entered_valid_password(String passwordText){
        driver.findElement(By.id("pass")).sendKeys(passwordText);

    }
    @And("user clicked on signIn button")
    public void user_clicked_on_signIn_button() throws InterruptedException {
        driver.findElement(By.id("send2")).click();
        Thread.sleep(1000);

    }
    @Then("user navigate to my account page")
    public void user_navigate_to_my_account_page(){
        Assert.assertTrue(driver.findElement(By.
                xpath("//div[@class='panel header']/ul/li/span[@class='logged-in']")).isDisplayed());

    }
    @And("user entered invalid password {string}")
    public void user_entered_invalid_password(String passwordText){

        driver.findElement(By.id("pass")).sendKeys(passwordText);
    }
    @When("user entered invalid email {string}")
    public void user_entered_invalid_email(String emailText){
        driver.findElement(By.id("email")).sendKeys(emailText);

    }
    @Then("user gets credential mismatch warning message")
    public void user_gets_credential_mismatch_warning_message(){
        String actualWarningMessage = driver.findElement
                (By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        String expectedWarningMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }
    @Then("user gets credential missing warning message")
    public void user_gets_credential_missing_warning_message(){
        String actualWarningMessage = driver.findElement
                (By.xpath("//div[text()='If you have an account, sign in with your email address.']")).getText();
        String expectedWarningMessage = "If you have an account, sign in with your email address.";
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
    }

    @After
    public void tearUp(){
        driver.quit();
    }

}

package com.bdd.step_definition;

import com.bdd.DataProvider.DataProvider;
import com.bdd.DriverLogic.DriverFactory;
import com.bdd.Pages.CustomerLoginPage;
import com.bdd.Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class SignIn extends DataProvider {
    public WebDriver driver;
    public HomePage homePage;
    public CustomerLoginPage customerLoginPage;

    public SignIn() throws IOException {
        super();
    }


    @Given("user navigate to SignIn page")
    public void user_navigate_to_SignIn_page(){
        driver = DriverFactory.getDriver();
       homePage = new HomePage(driver);
       customerLoginPage = homePage.clickOnSignInLink();
    }
    @When("user entered valid email {string}")
    public void user_entered_valid_email(String emailText){
        customerLoginPage.enterEmail(emailText);

    }
    @And("user entered valid password {string}")
    public void user_entered_valid_password(String passwordText){
        customerLoginPage.enterPassword(passwordText);

    }
    @And("user clicked on signIn button")
    public void user_clicked_on_signIn_button() throws InterruptedException {
       customerLoginPage.clickOnSignInButton();
        Thread.sleep(1000);

    }
    @Then("user navigate to my account page")
    public void user_navigate_to_my_account_page(){
        Assert.assertTrue(customerLoginPage.getSignInWelcomeText().contains(dataProp.getProperty("SignInConfirmationText")));

    }
    @And("user entered invalid password {string}")
    public void user_entered_invalid_password(String passwordText){

       customerLoginPage.enterPassword(passwordText);
    }
    @When("user entered invalid email {string}")
    public void user_entered_invalid_email(String emailText){
        customerLoginPage.enterEmail(emailText);

    }
    @Then("user gets credential mismatch warning message")
    public void user_gets_credential_mismatch_warning_message(){
        Assert.assertTrue(customerLoginPage.getErrorMessageForInvalidCredential().contains
                (dataProp.getProperty("ErrorMessageForInvalidCredential")));
    }
    @Then("user gets credential missing warning message")
    public void user_gets_credential_missing_warning_message(){
        Assert.assertTrue(customerLoginPage.getErrorMessageForMissingCredential().contains
                (dataProp.getProperty("errorMessageForMissingCredential")));
    }

}

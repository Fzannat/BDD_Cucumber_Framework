package com.bdd.step_definition;

import com.bdd.DataProvider.DataProvider;
import com.bdd.DriverLogic.DriverFactory;
import com.bdd.Pages.CreateNewCustomerPage;
import com.bdd.Pages.HomePage;
import com.bdd.Pages.MyAccountPage;
import com.luma.bdd.qa.Utilities.Util;
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

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class CreateAnAccount extends DataProvider {
    public WebDriver driver;
    public HomePage homePage;
    public CreateNewCustomerPage createNewCustomerPage;
    public MyAccountPage myAccountPage;

    public CreateAnAccount() throws IOException {
        super();
    }


    @Given("user navigate to create an account page")
    public void user_navigate_to_create_an_account_page() throws InterruptedException {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        createNewCustomerPage = homePage.clickOnCreateANewAccountLink();
        driver.findElement(By.xpath("//div[@class = 'panel header']//descendant::a[contains(text(), 'Create an Account')]")).click();

    }
    @And("user clicked on createAnAccount button")
    public void user_clicked_on_create_an_account_button() throws InterruptedException {
      myAccountPage = createNewCustomerPage.clickOnCreateAnAccountButton();
        Thread.sleep(1000);

    }
    @When("user entered all the below field")
    public void user_entered_all_the_below_field(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        createNewCustomerPage.createAnAccountWithAllMandatoryDetail(dataMap.get("firstName"), dataMap.get("firstName"),
                Util.generateEmailWithDateTimeStamp(),dataMap.get("password"));
    }
    @When("user entered all the below with duplicateEmail")
    public void user_entered_all_the_below_field_with_duplicate_email(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        createNewCustomerPage.createAnAccountWithAllMandatoryDetail(dataMap.get("firstName"), dataMap.get("firstName"),
                "f@gmal.com",dataMap.get("password"));

    }
    @Then("user Account gets created")
    public void user_account_gets_created() {
        Assert.assertTrue(myAccountPage.getConfirmationMessage().contains(dataProp.getProperty("accountSuccessMessage")));

    }

    @Then("user gets error massage for using duplicate email")
    public void user_gets_error_massage_for_using_duplicate_email() {
        Assert.assertTrue(createNewCustomerPage.getDuplicateEmailErrorMessage().contains
                (dataProp.getProperty("duplicateEmailErrorMessage")));
    }


    @Then("user gets error messages for all required fields")
    public void user_gets_error_messages_for_all_required_fields() {
        Assert.assertTrue(createNewCustomerPage.retrieveAllWarningMessageStatus(dataProp.getProperty("requiredFieldErrorMessage")));

    }



}

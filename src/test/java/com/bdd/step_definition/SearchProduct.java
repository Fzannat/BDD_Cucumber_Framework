package com.bdd.step_definition;

import com.bdd.DataProvider.DataProvider;
import com.bdd.DriverLogic.DriverFactory;
import com.bdd.Pages.HomePage;
import com.bdd.Pages.ProductDetailPage;
import com.bdd.Pages.SearchProductPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class SearchProduct extends DataProvider {

    public WebDriver driver;
    public HomePage homePage;
    public SearchProductPage searchProductPage;
    public ProductDetailPage productDetailPage;

    public SearchProduct() throws IOException {
        super();
    }


    @Given("user enter a product name in the search box")
    public void user_enter_a_product_name_in_the_search_box() throws InterruptedException {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        searchProductPage = homePage.enterProductName(dataProp.getProperty("searchingProduct"));
    }

    @When("user clicked on a product")
    public void user_clicked_on_a_product() throws InterruptedException {
        productDetailPage = searchProductPage.clickOnRadiantTShirt();
    }

    @Then("user navigate to product detail page")
    public void user_navigate_to_product_detail_page() {
        Assert.assertTrue(productDetailPage.getProductName().contains(dataProp.getProperty("radiantProductName")));
    }
}


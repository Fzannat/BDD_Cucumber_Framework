package com.bdd.step_definition;

import com.bdd.DataProvider.DataProvider;
import com.bdd.DriverLogic.DriverFactory;
import com.bdd.Pages.HomePage;
import com.bdd.Pages.ProductDetailPage;
import com.bdd.Pages.ShoppingCartPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class ShoppingCart extends DataProvider {
    public WebDriver driver;
    public HomePage homePage;
    public ProductDetailPage productDetailPage;
    public ShoppingCartPage shoppingCartPage;

    public ShoppingCart() throws IOException {
        super();
    }


    @Given("user choose an product and add this to the shopping cart")
    public void user_choose_an_product_and_add_this_to_the_shopping_cart() throws InterruptedException {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        productDetailPage = homePage.clickOnRadiantTShirt();
        productDetailPage.addAProductToTheCart();
    }
    @When("user navigate to the shopping cart option")
    public void user_navigate_to_the_shopping_cart_option() throws InterruptedException {
        shoppingCartPage = productDetailPage.clickOnShoppingCartLink();
    }
    @Then("user verify the valid product is added")
    public void user_verify_the_valid_product_is_added() {
        Assert.assertTrue(shoppingCartPage.getAddedProductNameFromCart().contains(dataProp.getProperty("radiantProductName")));
    }


}

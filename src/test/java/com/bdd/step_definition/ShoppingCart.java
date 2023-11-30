package com.bdd.step_definition;

import com.bdd.DriverLogic.DriverFactory;
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

public class ShoppingCart {
    public WebDriver driver;


    @Given("user choose an product and add this to the shopping cart")
    public void user_choose_an_product_and_add_this_to_the_shopping_cart() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.findElement(By.xpath(" //a[contains(text(), 'Radiant Tee')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("option-label-size-143-item-167")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("option-label-color-93-item-56")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("product-addtocart-button")).click();
        Thread.sleep(1000);
    }
    @When("user navigate to the shopping cart option")
    public void user_navigate_to_the_shopping_cart_option() throws InterruptedException {
        driver.findElement(By.linkText("shopping cart")).click();
        Thread.sleep(1000);
    }
    @Then("user verify the valid product is added")
    public void user_verify_the_valid_product_is_added() {
        String actualProductName = driver.findElement(By.xpath("//tbody[@class ='cart item']/descendant::strong/a")).getText();
        String expectedProductName = "Radiant Tee";
        Assert.assertTrue(actualProductName.contains(expectedProductName));
    }


}

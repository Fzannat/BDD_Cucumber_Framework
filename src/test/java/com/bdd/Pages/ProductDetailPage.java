package com.bdd.Pages;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
    public WebDriver driver;

    @FindBy(className = "base")
    private WebElement productName;

    @FindBy(id = "option-label-size-143-item-167")
    private WebElement smallSize;

    @FindBy(id = "option-label-color-93-item-56")
    private WebElement orangeColor;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(linkText = "shopping cart")
    private WebElement shoppingCartLink;



    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getProductName(){
        return productName.getText();
    }
    public void addAProductToTheCart() throws InterruptedException {
        smallSize.click();
        Thread.sleep(1000);
        orangeColor.click();
        Thread.sleep(1000);
        addToCartButton.click();
        Thread.sleep(1000);

    }
    public ShoppingCartPage clickOnShoppingCartLink() throws InterruptedException {
        shoppingCartLink.click();
        Thread.sleep(1000);
        return new ShoppingCartPage(driver);
    }
}

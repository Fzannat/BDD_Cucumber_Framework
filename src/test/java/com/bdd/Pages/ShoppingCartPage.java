package com.bdd.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    public WebDriver driver;

    @FindBy(xpath = "//tbody[@class ='cart item']/descendant::strong/a")
    private WebElement productNameFromTheCar;


    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAddedProductNameFromCart(){
        return productNameFromTheCar.getText();
    }
}

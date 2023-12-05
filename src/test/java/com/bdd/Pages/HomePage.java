package com.bdd.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    public WebDriver driver;

    @FindBy(xpath = "//span[text() = 'Sale']")
    private WebElement saleOption;

    @FindBy(xpath = "//span[text() = 'Sale']")
    private WebElement womenOption;

    @FindBy(linkText = "Create an Account")
    private WebElement createAnAccountLink;
    @FindBy(xpath = "//div[@class = 'panel header']//descendant::a[contains(text(), 'Sign In')]")
    private WebElement signInLink;

    @FindBy(id = "search")
    private WebElement searchBox;

    @FindBy(xpath = "//a[contains(text(), 'Radiant Tee')]")
    private WebElement radiantTShirtLink;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public SearchProductPage enterProductName(String productName) throws InterruptedException {
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        return new SearchProductPage(driver);
    }



    public CreateNewCustomerPage clickOnCreateANewAccountLink(){
        createAnAccountLink.click();
        return new CreateNewCustomerPage(driver);
    }
    public CustomerLoginPage clickOnSignInLink(){
        signInLink.click();
        return new CustomerLoginPage(driver);
    }
    public ProductDetailPage clickOnRadiantTShirt() throws InterruptedException {
        radiantTShirtLink.click();
        Thread.sleep(1000);
        return new ProductDetailPage(driver);
    }


}

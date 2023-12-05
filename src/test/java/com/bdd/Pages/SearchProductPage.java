package com.bdd.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {
    public WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'Radiant Tee')]")
    private WebElement radiantTShirtLink;


    public SearchProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductDetailPage clickOnRadiantTShirt() throws InterruptedException {
        radiantTShirtLink.click();
        Thread.sleep(1000);
        return new ProductDetailPage(driver);
    }
}

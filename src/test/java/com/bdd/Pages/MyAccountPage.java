package com.bdd.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public WebDriver driver;

    @FindBy(xpath = "//div[text() = 'Thank you for registering with Main Website Store.']")
    private WebElement confirmationMessage;



    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }
}


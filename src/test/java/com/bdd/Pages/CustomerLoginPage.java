package com.bdd.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {
    public WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailInputBox;

    @FindBy(id = "pass")
    private WebElement passwordInputBox;

    @FindBy(id = "send2")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='panel header']/descendant::li[@class = 'greet welcome']/span")
    private WebElement signInWelcomeMessage;

    @FindBy(xpath = "//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")
    private WebElement errorMessageForInvalidCredential;

    @FindBy(xpath = "//div[text()='If you have an account, sign in with your email address.']")
    private WebElement errorMessageForMissingCredential;


    public CustomerLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void enterEmail(String email){
        emailInputBox.sendKeys(email);
    }
    public void enterPassword(String password){
       passwordInputBox.sendKeys(password);
    }
    public void clickOnSignInButton(){
        signInButton.click();
    }
    public String getSignInWelcomeText(){
        return signInWelcomeMessage.getText();
    }
    public String getErrorMessageForInvalidCredential(){
        return errorMessageForInvalidCredential.getText();
    }
    public String getErrorMessageForMissingCredential(){
        return errorMessageForMissingCredential.getText();
    }
}

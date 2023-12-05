package com.bdd.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCustomerPage{
    public WebDriver driver;
    @FindBy(id = "firstname")
    private WebElement firstNameInputBox;

    @FindBy(id = "lastname")
    private WebElement lastNameInputBox;

    @FindBy(id = "email_address")
    private WebElement emailAddressNameInputBox;

    @FindBy(id = "password")
    private WebElement passwordInputBox;

    @FindBy(id = "password-confirmation")
    private WebElement confirmedPasswordInputBox;

    @FindBy(xpath = "//button[@title='Create an Account']/parent::div")
    private WebElement createAnAccountButton;

    @FindBy(xpath = "//div[contains(text(),'There is already an account with this email address. If you are sure that it is your email address,')]")
    private WebElement duplicateEmailErrorMessage;

    @FindBy(id ="firstname-error")
    private WebElement actualFirstNameErrorMessage;

    @FindBy(id ="lastname-error")
    private WebElement actualLastNameErrorMessage;

    @FindBy(id ="email_address-error")
    private WebElement actualEmailErrorMessage;

    @FindBy(id ="password-error")
    private WebElement actualPasswordErrorMessage;

    @FindBy(id ="password-confirmation-error")
    private WebElement actualPasswordConfirmErrorMessage;



    public CreateNewCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterFirstname(String firstName){
        firstNameInputBox.sendKeys(firstName);
    }
    public void enterLastname(String lastName){
        lastNameInputBox.sendKeys(lastName);
    }
    public void enterEmailAddress(String email){
        emailAddressNameInputBox.sendKeys(email);
    }
    public void enterPassword(String password){
        passwordInputBox.sendKeys(password);
    }
    public void enterConfirmPassword(String password){
        confirmedPasswordInputBox.sendKeys(password);
    }
    public MyAccountPage clickOnCreateAnAccountButton() throws InterruptedException {
        createAnAccountButton.click();
        Thread.sleep(1000);
        return new MyAccountPage(driver);
    }
    public void createAnAccountWithAllMandatoryDetail(String firstName, String lastName, String email, String password) throws InterruptedException {
        enterFirstname(firstName);
        enterLastname(lastName);
        enterEmailAddress(email);
        enterPassword(password);
        enterConfirmPassword(password);

    }
    public String getDuplicateEmailErrorMessage(){
        return duplicateEmailErrorMessage.getText();
    }
    public boolean retrieveAllWarningMessageStatus(String requiredFieldErrorMessage ){
        boolean statusOfFirstNameErrorMessage = actualFirstNameErrorMessage.getText().contains(requiredFieldErrorMessage);
        boolean statusOfLastNameErrorMessage = actualLastNameErrorMessage.getText().contains(requiredFieldErrorMessage);
        boolean statusOfEmailErrorMessage = actualEmailErrorMessage.getText().contains(requiredFieldErrorMessage);
        boolean statusOfPasswordMessage = actualPasswordErrorMessage.getText().contains(requiredFieldErrorMessage);
        boolean statusOfPasswordConfirmErrorMessage = actualPasswordConfirmErrorMessage.getText().contains(requiredFieldErrorMessage);
        return statusOfFirstNameErrorMessage && statusOfLastNameErrorMessage && statusOfEmailErrorMessage
                && statusOfPasswordMessage && statusOfPasswordConfirmErrorMessage;
    }
}
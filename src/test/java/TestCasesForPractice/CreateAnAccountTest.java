package TestCasesForPractice;

import com.luma.bdd.qa.Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAnAccountTest {
    public WebDriver driver;

    @Test
    public void registerTestWithAllDetail() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.id("firstname")).sendKeys("Fatema");
        driver.findElement(By.id("lastname")).sendKeys("Fatema");
        driver.findElement(By.id("email_address")).sendKeys(Util.generateEmailWithDateTimeStamp());
        driver.findElement(By.id("password")).sendKeys("Selenium@123");
        driver.findElement(By.id("password-confirmation")).sendKeys("Selenium@123");
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();
        Thread.sleep(1000);
        String actualConfirmationText = driver.findElement(By.xpath(
                "//div[text() = 'Thank you for registering with Main Website Store.']")).getText();
        String expectedConfirmationText = "Thank you for registering with Main Website Store.";
        Assert.assertTrue(actualConfirmationText.contains(expectedConfirmationText));
        driver.quit();

    }
    @Test
    public void registerTestWithAllDetail1() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.id("firstname")).sendKeys("Fatema");
        driver.findElement(By.id("lastname")).sendKeys("Fatema");
        driver.findElement(By.id("email_address")).sendKeys("f@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Selenium@123");
        driver.findElement(By.id("password-confirmation")).sendKeys("Selenium@123");
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();
        Thread.sleep(1000);
        String actualConfirmationText = driver.findElement(By.xpath(
                "//div[contains(text(),'There is already an account with this email address. If you are sure that it is your email address,')]")).getText();
        System.out.println(actualConfirmationText);
        String expectedConfirmationText = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        Assert.assertTrue(actualConfirmationText.contains(expectedConfirmationText));

    }
    @Test
    public void createAccountWithoutAnyDetail() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();
        Thread.sleep(1000);
        String actualFirstNameErrorMessage = driver.findElement(By.id("firstname-error")).getText();
        String expectedFirstNameErrorMessage = "This is a required field.";
        String actualLastNameErrorMessage = driver.findElement(By.id("lastname-error")).getText();
        String expectedLastNameErrorMessage = "This is a required field.";
        String actualEmailAddressErrorMessage = driver.findElement(By.id("email_address-error")).getText();
        String expectedEmailAddressErrorMessage = "This is a required field.";
        String actualPasswordErrorMessage = driver.findElement(By.id("password-error")).getText();
        String expectedPasswordErrorMessage = "This is a required field.";
        String actualPasswordConfirmationErrorMessage = driver.findElement(By.id("password-confirmation-error")).getText();
        String expectedPasswordConfirmationErrorMessage = "This is a required field.";
        Assert.assertTrue(actualFirstNameErrorMessage.contains(expectedFirstNameErrorMessage) && actualLastNameErrorMessage.contains(expectedLastNameErrorMessage)
            && actualEmailAddressErrorMessage.contains(expectedEmailAddressErrorMessage) &&
                actualPasswordErrorMessage.contains(expectedPasswordErrorMessage)
            && actualPasswordConfirmationErrorMessage.contains(expectedPasswordConfirmationErrorMessage));



    }
}

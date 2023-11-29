package TestLogin;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoinTest {
    public WebDriver driver;

    @Test
    public void loginTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("//div[@class = 'panel header']//descendant::a[contains(text(), 'Sign In')]")).click();
        driver.findElement(By.id("email")).sendKeys("fatema@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Selenium@123");
        driver.findElement(By.id("send2")).click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.
                xpath("//div[@class='panel header']/ul/li/span[@class='logged-in']")).isDisplayed());
        driver.quit();
    }
}

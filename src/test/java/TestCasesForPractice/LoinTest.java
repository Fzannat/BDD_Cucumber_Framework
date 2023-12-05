package TestCasesForPractice;

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
        System.out.println(driver.getTitle());
        driver.findElement(By.id("email")).sendKeys("fatema@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Selenium@123");
        driver.findElement(By.id("send2")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        String dd = driver.findElement(By.xpath
                ("//div[@class='panel header']/descendant::li[@class = 'greet welcome']/span")).getText();
        System.out.println(dd);
        Assert.assertTrue(dd.contains("Welcome, Fatema Zannat!"));
        driver.quit();
    }
}

package TestLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShoppingCart {

    public WebDriver driver;


    @Test
    public void testShoppingCart() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(1000));
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath(" //a[contains(text(), 'Radiant Tee')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("option-label-size-143-item-167")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("option-label-color-93-item-56")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("product-addtocart-button")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("shopping cart")).click();
        Thread.sleep(1000);
        String actualProductName = driver.findElement(By.xpath("//tbody[@class ='cart item']/descendant::strong/a")).getText();
        String expectedProductName = "Radiant Tee";
        Assert.assertTrue(actualProductName.contains(expectedProductName));
    }
}

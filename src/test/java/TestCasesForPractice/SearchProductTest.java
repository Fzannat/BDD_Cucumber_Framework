package TestCasesForPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchProductTest {
    public WebDriver driver;

    @Test
    public void testSearchProductPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(1000));
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("tshirts for women");
        searchBox.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(text(), 'Radiant Tee')] ")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.className("base")).getText().contains("Radiant Tee"));

    }
}

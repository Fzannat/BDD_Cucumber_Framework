package step_definition;

import com.bdd.DriverLogic.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SearchProduct {

    public WebDriver driver;


    @Given("user enter a product name in the search box")
    public void user_enter_a_product_name_in_the_search_box() throws InterruptedException {
        driver = DriverFactory.getDriver();
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("tshirts for women");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @When("user clicked on a product")
    public void user_clicked_on_a_product() throws InterruptedException {

        driver.findElement(By.xpath("//a[contains(text(), 'Radiant Tee')] ")).click();
        Thread.sleep(1000);



    }

    @Then("user navigate to product detail page")
    public void user_navigate_to_product_detail_page() {

        Assert.assertTrue(driver.findElement(By.className("base")).getText().contains("Radiant Tee"));

    }
}


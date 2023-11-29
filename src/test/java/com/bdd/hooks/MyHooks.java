package com.bdd.hooks;

import com.bdd.DriverLogic.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyHooks extends DriverFactory {
    @Before
    public void setup(){
        DriverFactory.initializeBrowser("chrome");
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(1000));
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @After
    public void tearUp(){
        driver.quit();
    }
}

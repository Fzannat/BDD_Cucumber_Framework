package com.bdd.hooks;

import com.bdd.DriverLogic.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MyHooks extends DriverFactory {
    public Properties prop;
    public FileInputStream ip;

    public MyHooks() throws IOException {
        prop = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/luma/bdd/qa/Utilities/Config/Config.properties");
        prop.load(ip);
    }
    @Before
    public void setup(){
        DriverFactory.initializeBrowser(prop.getProperty("browserName"));
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(1000));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearUp(){
        driver.quit();
    }
}

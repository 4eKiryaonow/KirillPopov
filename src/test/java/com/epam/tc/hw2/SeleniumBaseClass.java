package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumBaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ChromeOptions options;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        //Step 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        //set Explicity
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        //12. Close Browser
        driver.quit();

    }
}

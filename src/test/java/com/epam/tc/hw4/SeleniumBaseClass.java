package com.epam.tc.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public abstract class SeleniumBaseClass {

    public static final long TIMEOUT_SECONDS = 10;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ChromeOptions options;

    @BeforeMethod()
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.navigate().to(new TestData().getUrl());
        context.setAttribute("driver", driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));

    }

    @AfterMethod
    public void tearDown() {
        //12. Close Browser
        driver.quit();
    }
}

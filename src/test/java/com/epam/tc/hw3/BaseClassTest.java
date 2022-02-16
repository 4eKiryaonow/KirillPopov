package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseClassTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        driver.quit();
    }


}

package com.epam.tc.hw6;

import com.epam.tc.hw6.TestData;
import com.epam.tc.hw6.service.webdriver.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumBaseClass {

    protected static final long TIMEOUT_SECONDS = 10;
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp(Object[] data, ITestContext context) {

        driver = WebDriverProvider.getDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        driver.navigate().to(PropertiesReader.getProperty("url"));
        context.setAttribute("driver", driver);

    }

    @AfterMethod
    public void tearDown() {
        WebDriverProvider.closeDriver();
    }
}

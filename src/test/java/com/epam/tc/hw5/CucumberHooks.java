package com.epam.tc.hw5;

import com.epam.tc.hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CucumberHooks {

    private WebDriver driver;
    private ChromeOptions options;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void setUp() {
        options = new ChromeOptions()
            .addArguments("start-maximized",
                "-disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        TestContext.getInstance().setObject("driver", driver);
    }

    @After
    public void tearDown() {
        driver.quit();
        TestContext.getInstance().cleanContext();
    }
}

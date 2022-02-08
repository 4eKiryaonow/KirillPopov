package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestForFirstExercise {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Step 1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test

    public void testForFirstExercise() {
        //Step 2. Assert Browser title
        SoftAssert assertBrowserTitle = new SoftAssert();
        assertBrowserTitle.assertEquals(driver.getTitle(), "Home Page");

        //Step 3. Perform login
        List<WebElement> suggestions = driver.findElements(By.className("dropdown-toggle"));
        suggestions.get(1).click();

        WebElement username = driver.findElement(By.id("name"));
        username.sendKeys("Roman");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Jdi1234");

        WebElement buttonEnter = driver.findElement(By.id("login-button"));
        buttonEnter.click();

        //4. Assert Username is loggined
        SoftAssert assertUserLoggined = new SoftAssert();
        WebElement logusername = driver.findElement(By.id("user-name"));
        assertUserLoggined.assertEquals(logusername.getText(), "ROMAN IOVLEV");

    }



}

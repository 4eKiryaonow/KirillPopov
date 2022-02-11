package com.epam.tc.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test

    public void testForFirstExercise() {
        //Step 2. Assert Browser title
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Home Page");

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

        WebElement logusername = driver.findElement(By.id("user-name"));
        softAssert.assertEquals(logusername.getText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper text
        WebElement findHeaderSection = driver.findElement(By.className("m-l8"));
        findHeaderSection.isDisplayed();
        softAssert.assertTrue(findHeaderSection.getText().contains("HOME"));
        softAssert.assertTrue(findHeaderSection.getText().contains("CONTACT FORM"));
        softAssert.assertTrue(findHeaderSection.getText().contains("SERVICE"));
        softAssert.assertTrue(findHeaderSection.getText().contains("METALS & COLORS"));

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(driver.findElement(By.className("icon-practise")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.className("icon-custom")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.className("icon-multi")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.className("icon-base")).isDisplayed());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textUnderImage = driver.findElements(By.className("benefit-txt"));



        //Check text under the first image
        softAssert.assertTrue(textUnderImage.get(0).isDisplayed());
        softAssert.assertTrue(textUnderImage.get(0).getText().startsWith("To include good practices"));
        softAssert.assertTrue(textUnderImage.get(0).getText().contains("ideas from successful"));
        softAssert.assertTrue(textUnderImage.get(0).getText().endsWith("EPAM project"));

        //check text under the second image
        softAssert.assertTrue(textUnderImage.get(1).isDisplayed());
        softAssert.assertTrue(textUnderImage.get(1).getText().startsWith("To be flexible and"));
        softAssert.assertTrue(textUnderImage.get(1).getText().endsWith("customizable"));

        //check text under the third image
        softAssert.assertTrue(textUnderImage.get(2).isDisplayed());
        softAssert.assertTrue(textUnderImage.get(2).getText().contains("To be multiplatform"));

        //check text under the fourth image
        softAssert.assertTrue(textUnderImage.get(3).isDisplayed());
        softAssert.assertTrue(textUnderImage.get(3).getText().startsWith("Already have good base"));
        softAssert.assertTrue(textUnderImage.get(3).getText().contains("(about 20 internal and"));
        softAssert.assertTrue(textUnderImage.get(3).getText().contains("some external projects),"));
        softAssert.assertTrue(textUnderImage.get(3).getText().endsWith("wish to get more…"));


        //8. Assert that there is the iframe with “Frame Button” exist
        WebElement findFrameBtn = driver.findElement(By.xpath("//iframe[@id='frame']"));
        softAssert.assertTrue(findFrameBtn.isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement findFrameButton = driver
                .switchTo()
                .frame("frame")
                .findElement(By.id("frame-button"));
        softAssert.assertTrue(findFrameButton.isDisplayed());

        //10. Switch to original window back
        driver.switchTo().parentFrame();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement findLefBar = driver.findElement(By.className("left"));

        softAssert.assertTrue(findLefBar.isDisplayed());
        softAssert.assertTrue(findLefBar.getText().contains("Home"));
        softAssert.assertTrue(findLefBar.getText().contains("Contact form"));
        softAssert.assertTrue(findLefBar.getText().contains("Service"));
        softAssert.assertTrue(findLefBar.getText().contains("Metals & Colors"));
        softAssert.assertTrue(findLefBar.getText().contains("Elements packs"));

        softAssert.assertAll();


    }
}

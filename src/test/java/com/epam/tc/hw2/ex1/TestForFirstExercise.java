package com.epam.tc.hw2.ex1;

import static org.assertj.core.util.Lists.newArrayList;

import com.epam.tc.hw2.SeleniumBaseClass;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;




public class TestForFirstExercise extends SeleniumBaseClass {


    @Test
    public void testForFirstExercise() {

        //Step 2. Assert Browser title
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getTitle()).isEqualTo("Home Page");

        //Step 3. Perform login
        WebElement findDropDown = driver.findElement(By.className("navbar-right"));
        wait.until(ExpectedConditions.elementToBeClickable(findDropDown)).click();

        WebElement username = driver.findElement(By.id("name"));
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("Roman");

        WebElement password = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("Jdi1234");

        WebElement buttonEnter = driver.findElement(By.id("login-button"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonEnter)).click();

        //4. Assert Username is loggined
        WebElement logUsername = driver.findElement(By.id("user-name"));
        wait.until(ExpectedConditions.visibilityOf(logUsername));
        softly.assertThat(logUsername.getText()).isEqualTo("ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper text
        List<WebElement> findHeaderItems = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector(".m-l8 > li"), 3));

        List<String> expectedHeaderItems = newArrayList(
                "HOME",
                "CONTACT FORM",
                "SERVICE",
                "METALS & COLORS"
        );

        softly.assertThat(findHeaderItems)
                .extracting(WebElement::getText)
                .containsExactlyElementsOf(expectedHeaderItems);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> imageItems = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector("div[class*=benefit] > span[class*=icons-benefit]"), 3));

        softly.assertThat(imageItems).hasSize(4).allMatch(WebElement::isDisplayed);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textUnderImage = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By.className("benefit-txt"), 3));

        List<String> expectedTextUnderImages = newArrayList(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        );

        softly.assertThat(textUnderImage)
                .extracting(WebElement::getText)
                .containsExactlyElementsOf(expectedTextUnderImages);

        //8. Assert that there is the iframe with “Frame Button” exist
        softly.assertThat(driver.findElement(By.id("frame")).isDisplayed()).isTrue();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        softly.assertThat(driver.findElement(By.id("frame-button")).isDisplayed()).isTrue();

        //10. Switch to original window back
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.titleIs("Home Page"));

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> findLeftBar = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.cssSelector(".left > li"), 4));

        List<String> expectedItemsLeftBar = newArrayList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        );

        softly.assertThat(findLeftBar)
                .extracting(WebElement::getText)
                .containsExactlyElementsOf(expectedItemsLeftBar);

        softly.assertAll();


    }
}

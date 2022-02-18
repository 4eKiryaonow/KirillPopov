package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.BaseClassTest;
import com.epam.tc.hw3.PropertiesReader;
import com.epam.tc.hw3.pageobject.HomePageObject;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class TestForFirstExercise extends BaseClassTest {



    @Test
    public void testForFirstExercise() {
        SoftAssert softAssert = new SoftAssert();
        HomePageObject homePageObject = new HomePageObject(driver);

        //Step 2. Assert Browser title
        softAssert.assertEquals(homePageObject.getTitle(), "Home Page");

        //Step 3. Perform login
        homePageObject.header()
                .login(PropertiesReader.getProperty("username"), PropertiesReader.getProperty("password"));

        //4. Assert Username is loggined
        softAssert.assertEquals(homePageObject.getLoggedUserAsText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper text
        List<String> matcher = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        homePageObject.header()
                .getTitlesNavigationMenu()
                .forEach(title -> softAssert.assertTrue(matcher.contains(title)));

        //6. Assert that there are 4 images on the Index Page and they are displayed
        homePageObject.getListImages()
                .forEach(image -> softAssert.assertTrue(image.isDisplayed()));

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> textUnderImages = Arrays.asList(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
                );

        homePageObject.getListTextUnderImages()
                .stream()
                .map(WebElement::getText)
                .forEach(text -> softAssert.assertTrue(textUnderImages.contains(text)));

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePageObject.getFrameButton().isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(homePageObject.getButtonFromFrameButton().isDisplayed());

        //10. Switch to original window back
        homePageObject.switchToWindowBack();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> leftMenuItems = Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        );

        homePageObject.leftSideBar()
                .getTitlesLeftMenu()
                .forEach(title -> softAssert.assertTrue(leftMenuItems.contains(title)));

        homePageObject.leftSideBar()
                .getLeftSideBarMenu()
                .forEach(item -> softAssert.assertTrue(item.isDisplayed()));

        softAssert.assertAll();



    }


}

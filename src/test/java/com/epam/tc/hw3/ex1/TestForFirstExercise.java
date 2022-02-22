package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.PropertiesReader;
import com.epam.tc.hw3.SeleniumBaseClass;
import com.epam.tc.hw3.pageobject.HomePageObject;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestForFirstExercise extends SeleniumBaseClass {

    @Test
    public void testForFirstExercise() {
        SoftAssertions softly = new SoftAssertions();
        HomePageObject homePageObject = new HomePageObject(driver);

        //Step 2. Assert Browser title
        softly.assertThat(homePageObject.getTitle()).isEqualTo(PropertiesReader.getProperty("title"));

        //Step 3. Perform login
        homePageObject.header()
                      .login(PropertiesReader.getProperty("username"),
                          PropertiesReader.getProperty("password"));

        //4. Assert Username is loggined
        softly.assertThat(homePageObject.getLoggedUserAsText()).isEqualTo(PropertiesReader.getProperty("userLogged"));

        //5. Assert that there are 4 items on the header section are displayed and they have proper text
        List<String> expectedHeaderItems = List.of(
            "HOME",
            "CONTACT FORM",
            "SERVICE",
            "METALS & COLORS"
        );
        softly.assertThat(homePageObject.header().getTitlesNavigationMenu())
              .containsExactlyElementsOf(expectedHeaderItems);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<String> expectedTextUnderImages = List.of(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
        );
        softly.assertThat(homePageObject.getListImages())
              .hasSize(expectedTextUnderImages.size()).allMatch(WebElement::isDisplayed);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text

        softly.assertThat(homePageObject.getListTextUnderImages())
              .containsExactlyElementsOf(expectedTextUnderImages);

        //8. Assert that there is the iframe with “Frame Button” exist
        softly.assertThat(homePageObject.getFrameWithButton()).isNotEmpty();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageObject.switchToFrameButton();
        softly.assertThat(homePageObject.getButtonFromFrameButton()).isNotEmpty();

        //10. Switch to original window back
        homePageObject.switchToWindowBack();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> expectedItemsLeftBar = List.of(
            "Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs"
        );

        softly.assertThat(homePageObject.leftSideBar().getTitlesLeftMenu())
              .containsExactlyElementsOf(expectedItemsLeftBar);

        softly.assertAll();
    }
}

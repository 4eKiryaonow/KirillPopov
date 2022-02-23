package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.DataProvider;
import com.epam.tc.hw4.SeleniumBaseClass;
import com.epam.tc.hw4.pageobject.HomePageObject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestForFirstExercise extends SeleniumBaseClass {

    @Test
    public void testForFirstExercise() {
        SoftAssertions softly = new SoftAssertions();
        HomePageObject homePageObject = new HomePageObject(driver);
        DataProvider dataProvider = new DataProvider();

        //Step 2. Assert Browser title
        softly.assertThat(homePageObject.getTitle()).isEqualTo(dataProvider.getTitle());

        //Step 3. Perform login
        homePageObject.header()
                      .login(dataProvider.getUsername(),
                          dataProvider.getPassword());

        //4. Assert Username is loggined
        softly.assertThat(homePageObject.getLoggedUserAsText()).isEqualTo(dataProvider.getUserLogged());

        //5. Assert that there are 4 items on the header section are displayed and they have proper text
        softly.assertThat(homePageObject.header().getTitlesNavigationMenu())
              .containsExactlyElementsOf(dataProvider.getExpectedHeaderItems());

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softly.assertThat(homePageObject.getListImages())
              .hasSize(dataProvider.getExpectedTextUnderImages().size()).allMatch(WebElement::isDisplayed);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softly.assertThat(homePageObject.getListTextUnderImages())
              .containsExactlyElementsOf(dataProvider.getExpectedTextUnderImages());

        //8. Assert that there is the iframe with “Frame Button” exist
        softly.assertThat(homePageObject.getFrameWithButton()).isNotEmpty();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        homePageObject.switchToFrameButton();
        softly.assertThat(homePageObject.getButtonFromFrameButton()).isNotEmpty();

        //10. Switch to original window back
        homePageObject.switchToWindowBack();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text


        softly.assertThat(homePageObject.leftSideBar().getTitlesLeftMenu())
              .containsExactlyElementsOf(dataProvider.getExpectedItemsLeftBar());

        softly.assertAll();
    }
}

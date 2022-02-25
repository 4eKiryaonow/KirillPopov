package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.DataProvider;
import com.epam.tc.hw4.SeleniumBaseClass;
import com.epam.tc.hw4.pageobject.HomePageObject;
import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertionStep;
import org.testng.annotations.Test;

public class TestForFirstExercise extends SeleniumBaseClass {

    @Test
    public void testForFirstExercise() {
        HomePageObject homePageObject = new HomePageObject(driver);
        DataProvider dataProvider = new DataProvider();
        ActionStep actionStep = new ActionStep(driver, wait, homePageObject);
        AssertionStep assertionStep = new AssertionStep(driver, wait, homePageObject);

        //Step 1. Open test site by URL
        actionStep.openHomePage();

        //Step 2. Assert Browser title
        assertionStep.assertBrowserTitle(dataProvider.getTitle());

        //Step 3. Perform login
        actionStep.performLogin();

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLoggined(dataProvider.getUserLogged());

        //5. Assert that there are 4 items on the header section are displayed and they have proper text
        assertionStep.assertItemsOnHeader(dataProvider.getExpectedHeaderItems());

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.assertImagesAreDisplayed(dataProvider.getExpectedTextUnderImages());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.assertTextUnderImages(dataProvider.getExpectedTextUnderImages());

        //8. Assert that there is the iframe with “Frame Button” exist
        assertionStep.assertFrameIsExist();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertionStep.assertThatFrameButtonInFrame();

        //10. Switch to original window back
        actionStep.switchToOriginalWindowBack();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.assertItemsInLeftLogSection(dataProvider.getExpectedItemsLeftBar());


    }
}

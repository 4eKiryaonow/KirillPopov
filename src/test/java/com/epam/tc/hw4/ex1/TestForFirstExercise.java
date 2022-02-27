package com.epam.tc.hw4.ex1;

import com.epam.tc.hw4.DataProviderForTests;
import com.epam.tc.hw4.SeleniumBaseClass;
import com.epam.tc.hw4.TestData;
import com.epam.tc.hw4.pageobject.HomePageObject;
import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertionStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Homework 4")
@Story("Test for first exercise")
public class TestForFirstExercise extends SeleniumBaseClass {

    @Test(dataProviderClass = DataProviderForTests.class,
          dataProvider = "DataProviderForTests")
    public void testForFirstExercise(TestData data) {
        HomePageObject homePageObject = new HomePageObject(driver);
        ActionStep actionStep = new ActionStep(driver, wait, homePageObject);
        AssertionStep assertionStep = new AssertionStep(driver, wait, homePageObject);

        //Step 2. Assert Browser title
        assertionStep.assertBrowserTitle(data.getTitle());

        //Step 3. Perform login
        actionStep.performLogin(data.getUsername(), data.getPassword());

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLoggined(data.getUserLogged());

        //5. Assert that there are 4 items on the header section are displayed and they have proper text
        assertionStep.assertItemsOnHeader(data.getExpectedHeaderItems());

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.assertImagesAreDisplayed(data.getExpectedTextUnderImages());

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.assertTextUnderImages(data.getExpectedTextUnderImages());

        //8. Assert that there is the iframe with “Frame Button” exist
        assertionStep.assertFrameIsExist();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertionStep.assertThatFrameButtonInFrame();

        //10. Switch to original window back
        actionStep.switchToOriginalWindowBack();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.assertItemsInLeftLogSection(data.getExpectedItemsLeftBar());
    }
}

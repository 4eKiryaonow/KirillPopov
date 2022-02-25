package com.epam.tc.hw4.ex1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.DataProvider;
import com.epam.tc.hw4.SeleniumBaseClass;
import com.epam.tc.hw4.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw4.pageobject.HomePageObject;
import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertionStep;
import org.testng.annotations.Test;

public class TestForSecondExercise extends SeleniumBaseClass {

    @Test
    public void testForSecondExercise() {
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

        //5. Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();

        //6. Select checkboxes Water, Wind
        actionStep.selectCheckboxes();

        //7. Select radio
        actionStep.selectRadio();

        //8. Select in dropdown Yellow
        actionStep.selectColor(dataProvider.getColor());

        /* 9. Assert that:
        - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        - for radio button there is a log row and value is corresponded to the status of radio button
        - for dropdown there is a log row and value is corresponded to the selected value.
        */
        assertionStep.assertLogRowsInRightSideSection(dataProvider.getExpectedLogRows());
    }
}

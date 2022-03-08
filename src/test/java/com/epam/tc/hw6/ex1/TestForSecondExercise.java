package com.epam.tc.hw6.ex1;

import com.epam.tc.hw6.DataProviderForTests;
import com.epam.tc.hw6.SeleniumBaseClass;
import com.epam.tc.hw6.TestData;
import com.epam.tc.hw6.pageobject.HomePageObject;
import com.epam.tc.hw6.steps.ActionStep;
import com.epam.tc.hw6.steps.AssertionStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Homework 6")
@Story("Test for second exercise")
public class TestForSecondExercise extends SeleniumBaseClass {

    @Test(dataProviderClass = DataProviderForTests.class,
          dataProvider = "DataProviderForTests")
    public void testForSecondExercise(TestData data) {
        HomePageObject homePageObject = new HomePageObject(driver);
        ActionStep actionStep = new ActionStep(driver, wait, homePageObject);
        AssertionStep assertionStep = new AssertionStep(driver, wait, homePageObject);

        //Step 2. Assert Browser title
        assertionStep.assertBrowserTitle(data.getTitle());

        //Step 3. Perform login
        actionStep.performLogin(data.getUsername(), data.getPassword());

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLoggined(data.getUserLogged());

        //5. Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();

        //6. Select checkboxes Water, Wind
        actionStep.selectCheckboxes();

        //7. Select radio
        actionStep.selectRadio();

        //8. Select in dropdown Yellow
        actionStep.selectColor(data.getColor());

        /* 9. Assert that:
        - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        - for radio button there is a log row and value is corresponded to the status of radio button
        - for dropdown there is a log row and value is corresponded to the selected value.
        */
        assertionStep.assertLogRowsInRightSideSection(data.getExpectedLogRows());
    }
}

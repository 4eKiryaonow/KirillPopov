package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.BaseClassTest;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.DifferentElementsPageObject;
import pageobject.HomePageObject;

public class TestForSecondExercise extends BaseClassTest {

    @Test
    public void testForSecondExercise() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        HomePageObject homePageObject = new HomePageObject(driver);

        //Step 2. Assert Browser title
        softAssert.assertEquals(homePageObject.getTitle(), "Home Page");

        //Step 3. Perform login
        homePageObject.header()
                .login("Roman", "Jdi1234");

        //4. Assert Username is loggined
        softAssert.assertEquals(homePageObject.getLoggedUserAsText(), "ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        homePageObject.header().clickByDifferentElements();

        DifferentElementsPageObject differentElementsPageObject = new DifferentElementsPageObject(driver);

        //6. Select checkboxes Water, Wind
        differentElementsPageObject.clickCheckBoxWater();
        differentElementsPageObject.clickCheckBoxWind();

        //7. Select radio
        differentElementsPageObject.clickRadioSelen();

        //8. Select in dropdown Yellow
        differentElementsPageObject.selectColor("Yellow");


        /* 9. Assert that:
        - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        - for radio button there is a log row and value is corresponded to the status of radio button
        - for dropdown there is a log row and value is corresponded to the selected value.
        */

    }
}

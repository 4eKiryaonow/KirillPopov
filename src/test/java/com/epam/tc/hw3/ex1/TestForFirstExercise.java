package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.BaseClassTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobject.HomePageObject;


public class TestForFirstExercise extends BaseClassTest {



    @Test
    public void testForFirstExercise() {
        SoftAssert softAssert = new SoftAssert();
        HomePageObject homePageObject = new HomePageObject(driver);

        //Step 2. Assert Browser title
        softAssert.assertEquals(homePageObject.getTitle(), "Home Page");

        //Step 3. Perform login
        homePageObject.header()
                .login("Roman", "Jdi1234");

        //4. Assert Username is loggined
        softAssert.assertEquals(homePageObject.getLoggedUserAsText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper text



        softAssert.assertAll();

        //Step 2. Assert Browser title





    }


}

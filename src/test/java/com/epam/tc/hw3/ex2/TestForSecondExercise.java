package com.epam.tc.hw3.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw3.PropertiesReader;
import com.epam.tc.hw3.SeleniumBaseClass;
import com.epam.tc.hw3.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw3.pageobject.HomePageObject;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class TestForSecondExercise extends SeleniumBaseClass {

    @Test
    public void testForSecondExercise() {

        SoftAssert softAssert = new SoftAssert();
        HomePageObject homePageObject = new HomePageObject(driver);

        //Step 2. Assert Browser title
        softAssert.assertEquals(homePageObject.getTitle(), "Home Page");

        //Step 3. Perform login
        homePageObject.header()
                .login(PropertiesReader.getProperty("username"),
                        PropertiesReader.getProperty("password"));

        //4. Assert Username is loggined
        assertThat(homePageObject.getLoggedUserAsText()).isEqualTo("ROMAN IOVLEV");

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
        List<String> logRowsExpected = Arrays.asList(
                "Water: condition changed to true",
                "Wind: condition changed to true",
                "metal: value changed to Selen",
                "Colors: value changed to Yellow"
        );

        differentElementsPageObject.rightSideBar()
                .logsList()
                .stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("^\\d*[:]\\d*[:]\\d*\\s", ""))
                .forEach(text -> assertThat(text).isIn(logRowsExpected));





    }
}

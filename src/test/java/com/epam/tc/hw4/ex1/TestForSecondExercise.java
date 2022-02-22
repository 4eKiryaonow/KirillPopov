package com.epam.tc.hw4.ex1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.PropertiesReader;
import com.epam.tc.hw4.SeleniumBaseClass;
import com.epam.tc.hw4.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw4.pageobject.HomePageObject;
import java.util.List;
import org.testng.annotations.Test;

public class TestForSecondExercise extends SeleniumBaseClass {

    @Test
    public void testForSecondExercise() {

        HomePageObject homePageObject = new HomePageObject(driver);

        //Step 2. Assert Browser title
        assertThat(homePageObject.getTitle()).isEqualTo(PropertiesReader.getProperty("title"));

        //Step 3. Perform login
        homePageObject.header()
                      .login(PropertiesReader.getProperty("username"),
                          PropertiesReader.getProperty("password"));

        //4. Assert Username is loggined
        assertThat(homePageObject.getLoggedUserAsText()).isEqualTo(PropertiesReader.getProperty("userLogged"));

        //5. Open through the header menu Service -> Different Elements Page
        homePageObject.header().clickByDifferentElements();

        DifferentElementsPageObject differentElementsPageObject = new DifferentElementsPageObject(driver);

        //6. Select checkboxes Water, Wind
        differentElementsPageObject.clickCheckBoxWater();
        differentElementsPageObject.clickCheckBoxWind();

        //7. Select radio
        differentElementsPageObject.clickRadioSelen();

        //8. Select in dropdown Yellow
        differentElementsPageObject.selectColor(PropertiesReader.getProperty("color"));

        /* 9. Assert that:
        - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        - for radio button there is a log row and value is corresponded to the status of radio button
        - for dropdown there is a log row and value is corresponded to the selected value.
        */
        List<String> expectedLogRows = List.of(
            "Colors: value changed to Yellow",
            "metal: value changed to Selen",
            "Wind: condition changed to true",
            "Water: condition changed to true"
        );

        assertThat(differentElementsPageObject.rightSideBar().logsList())
            .containsExactlyElementsOf(expectedLogRows);
    }
}

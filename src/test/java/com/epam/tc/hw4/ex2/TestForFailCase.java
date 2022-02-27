package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.SeleniumBaseClass;
import com.epam.tc.hw4.pageobject.HomePageObject;
import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertionStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class TestForFailCase extends SeleniumBaseClass {

    @Feature("Homework 4")
    @Story("Test for second exercise")
    @Test
    public void testForFailCase() {

        HomePageObject homePageObject = new HomePageObject(driver);
        ActionStep actionStep = new ActionStep(driver, wait, homePageObject);
        AssertionStep assertionStep = new AssertionStep(driver, wait, homePageObject);

        //Step 2. Assert Browser title
        assertionStep.assertBrowserTitle("");
    }
}

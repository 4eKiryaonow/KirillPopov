package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.DataProvider;
import com.epam.tc.hw4.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw4.pageobject.HomePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    private HomePageObject homePageObject;
    private DifferentElementsPageObject differentElementsPageObject;
    private DataProvider dataProvider;

    public ActionStep(WebDriver driver) {
        super(driver);
        homePageObject = new HomePageObject(driver);
        differentElementsPageObject = new DifferentElementsPageObject(driver);
        dataProvider = new DataProvider();
    }

    @Step("Open test site by URL")
    public void openHomePage() {
        homePageObject.open(dataProvider.getUrl());
    }

    @Step("Perform login")
    public void performLogin() {
        homePageObject.header()
                      .login(dataProvider.getUsername(),
                          dataProvider.getPassword());
    }

    @Step("Switch to original window back")
    public void switchToOriginalWindowBack() {

        homePageObject.switchToWindowBack();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {

        homePageObject.header().clickByDifferentElements();
    }

    @Step("Select checkboxes")
    public void selectCheckboxes() {

        differentElementsPageObject.clickCheckBoxWater();
        differentElementsPageObject.clickCheckBoxWind();
    }

    @Step("Select radio")
    public void selectRadio() {

        differentElementsPageObject.clickRadioSelen();
    }

    @Step("Select in dropdown {1}")
    public void selectIn(String expectedColor) {
        differentElementsPageObject.selectColor(expectedColor);
    }

}

package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw4.pageobject.HomePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionStep extends AbstractStep {

    private DifferentElementsPageObject differentElementsPageObject;

    public ActionStep(WebDriver driver, WebDriverWait wait, HomePageObject homePageObject) {
        super(driver, wait, homePageObject);
        differentElementsPageObject = new DifferentElementsPageObject(driver);

    }

    @Step("Perform login")
    public void performLogin(String login, String password) {
        homePageObject.header()
                      .login(login, password);
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

    @Step("Select in dropdown {expectedColor}")
    public void selectColor(String expectedColor) {
        differentElementsPageObject.selectColor(expectedColor);
    }

}

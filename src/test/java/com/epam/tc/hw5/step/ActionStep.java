package com.epam.tc.hw5.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openSite() {

        homePageObject.open(testData.getUrl());
    }

    @And("I login as user \"Roman Iovlev\"")
    public void performLogin() {
        homePageObject.header()
                      .login(testData.getUsername(), testData.getPassword());
    }

    @When("I click on \"Service\" button in Header")
    public void clickOnServiceButton() {

        homePageObject.header().clickByServiceDropDownMenu();
    }

    @And("I click on \"Different Elements\" button in Service dropdown")
    public void openDifferentElementsPage() {

        homePageObject.header().clickByDifferentElements();
    }

    @And("I select checkboxes \"Water\", \"Wind\"")
    public void selectCheckboxes() {

        differentElementsPageObject.clickCheckBoxWater();
        differentElementsPageObject.clickCheckBoxWind();
    }

    @And("I select radio \"Selen\"")
    public void selectRadio() {

        differentElementsPageObject.clickRadioSelen();
    }

    @And("I Select in dropdown \"Yellow\"")
    public void selectColor() {
        differentElementsPageObject.selectColor(testData.getColor());
    }

    @And("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableButton() {

        homePageObject.header().clickByUserTableButton();

    }


}

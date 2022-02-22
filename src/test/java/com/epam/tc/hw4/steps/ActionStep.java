package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.PropertiesReader;
import com.epam.tc.hw4.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw4.pageobject.HomePageObject;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    private HomePageObject homePageObject;
    private DifferentElementsPageObject differentElementsPageObject;

    public ActionStep(WebDriver driver) {
        super(driver);
        homePageObject = new HomePageObject(driver);
    }

    @Step("Open test site by URL")
    public void openHomePage() {
        homePageObject.open(PropertiesReader.getProperty("url"));
    }

    @Step("Perform login")
    public void performLogin() {
        homePageObject.header()
                      .login(PropertiesReader.getProperty("username"),
                          PropertiesReader.getProperty("password"));
    }
}

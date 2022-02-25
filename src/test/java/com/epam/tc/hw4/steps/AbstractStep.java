package com.epam.tc.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.pageobject.HomePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractStep {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePageObject homePageObject;

    public AbstractStep(WebDriver driver, WebDriverWait wait, HomePageObject homePageObject) {
        this.driver = driver;
        this.wait = wait;
        this.homePageObject = homePageObject;
    }

    @Step("Assert Browser title {expectedTitle}")
    public void assertBrowserTitle(String expectedTitle) {

        assertThat(homePageObject.getTitle()).isEqualTo(expectedTitle);

    }
}

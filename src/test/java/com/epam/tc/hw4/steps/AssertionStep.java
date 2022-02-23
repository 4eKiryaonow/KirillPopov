package com.epam.tc.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw4.pageobject.HomePageObject;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep {

    private HomePageObject homePageObject;
    private DifferentElementsPageObject differentElementsPageObject;

    public AssertionStep(WebDriver driver) {
        super(driver);
        homePageObject = new HomePageObject(driver);
    }

    @Step("Assert Browser title")
    public void assertBrowserTitle(String expectedTitle) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePageObject.getTitle()).isEqualTo(expectedTitle);
        softly.assertAll();
    }

    @Step("Assert Username is loggined")
    public void assertUsernameIsLoggined(String expectedUsername) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePageObject.getLoggedUserAsText()).isEqualTo(expectedUsername);
        softly.assertAll();
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertItemsOnHeader(List<String> expectedHeaderItems) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePageObject.header().getTitlesNavigationMenu())
              .containsExactlyElementsOf(expectedHeaderItems);
        softly.assertAll();
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertImagesAreDisplayed(List<String> expectedListImages) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePageObject.getListImages())
              .hasSize(expectedListImages.size()).allMatch(WebElement::isDisplayed);
        softly.assertAll();
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertTextUnderImages(List<String> expectedTextInderImages) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePageObject.getListTextUnderImages())
              .containsExactlyElementsOf(expectedTextInderImages);
        softly.assertAll();
    }

    @Step("Assert that there is the iframe with “Frame Button” that there is the iframe with “Frame Button” exist")
    public void assertFrameIsExist() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePageObject.getFrameWithButton()).isNotEmpty();
        softly.assertAll();
    }

    @Step("Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void assertThatFrameButtonInFrame() {
        SoftAssertions softly = new SoftAssertions();
        homePageObject.switchToFrameButton();
        softly.assertThat(homePageObject.getButtonFromFrameButton()).isNotEmpty();
        softly.assertAll();
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertItemsInLeftLogSection(List<String> expectedItemsLeftBar) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePageObject.leftSideBar().getTitlesLeftMenu())
              .containsExactlyElementsOf(expectedItemsLeftBar);
        softly.assertAll();
    }

    @Step("Assert log rows in right side bar")
    public void assertLogRowsInRightSideSection(List<String> expectedLogRows) {

        assertThat(differentElementsPageObject.rightSideBar().logsList())
            .containsExactlyElementsOf(expectedLogRows);



    }
}

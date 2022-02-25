package com.epam.tc.hw4.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw4.DataProvider;
import com.epam.tc.hw4.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw4.pageobject.HomePageObject;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssertionStep extends AbstractStep {

    private DifferentElementsPageObject differentElementsPageObject;

    public AssertionStep(WebDriver driver, WebDriverWait wait, HomePageObject homePageObject) {
        super(driver, wait, homePageObject);
        differentElementsPageObject = new DifferentElementsPageObject(driver);
    }

    @Step("Assert Username is loggined")
    public void assertUsernameIsLoggined(String expectedUsername) {

        assertThat(homePageObject.getLoggedUserAsText()).isEqualTo(expectedUsername);
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertItemsOnHeader(List<String> expectedHeaderItems) {

        assertThat(homePageObject.header().getTitlesNavigationMenu())
            .containsExactlyElementsOf(expectedHeaderItems);
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertImagesAreDisplayed(List<String> expectedListImages) {

        assertThat(homePageObject.getListImages())
            .hasSize(expectedListImages.size()).allMatch(WebElement::isDisplayed);
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertTextUnderImages(List<String> expectedTextInderImages) {

        assertThat(homePageObject.getListTextUnderImages())
            .containsExactlyElementsOf(expectedTextInderImages);
    }

    @Step("Assert that there is the iframe with “Frame Button” that there is the iframe with “Frame Button” exist")
    public void assertFrameIsExist() {

        assertThat(homePageObject.getFrameWithButton()).isNotEmpty();
    }

    @Step("Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void assertThatFrameButtonInFrame() {

        homePageObject.switchToFrameButton();
        assertThat(homePageObject.getButtonFromFrameButton()).isNotEmpty();
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertItemsInLeftLogSection(List<String> expectedItemsLeftBar) {

        assertThat(homePageObject.leftSideBar().getTitlesLeftMenu())
            .containsExactlyElementsOf(expectedItemsLeftBar);
    }

    @Step("Assert log rows in right side bar")
    public void assertLogRowsInRightSideSection(List<String> expectedLogRows) {

        assertThat(differentElementsPageObject.rightSideBar().logsList())
            .containsExactlyElementsOf(expectedLogRows);
    }
}

package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.PropertiesReader;
import com.epam.tc.hw4.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw4.pageobject.HomePageObject;
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
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertItemsOnHeader(List<String> expectedHeaderItems) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePageObject.header().getTitlesNavigationMenu())
              .containsExactlyElementsOf(expectedHeaderItems);
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertImagesAreDisplayed(List<String> expectedListImages) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePageObject.getListImages())
              .hasSize(expectedListImages.size()).allMatch(WebElement::isDisplayed);



    }

}

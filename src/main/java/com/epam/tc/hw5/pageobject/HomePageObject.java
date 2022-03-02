package com.epam.tc.hw5.pageobject;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageObject extends AbstractPageObject {

    @FindBy(css = "div.benefit-icon > span.icons-benefit")
    private List<WebElement> listImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> listTextUnderImages;

    @FindBy(id = "frame")
    private List<WebElement> frameWithButton;

    @FindBy(id = "frame-button")
    private List<WebElement> frameButton;

    public HomePageObject(WebDriver driver) {

        super(driver);
    }

    public String getLoggedUserAsText() {

        return this.header.getLoggedUser().getText();
    }

    public List<WebElement> getListImages() {

        return this.listImages;

    }

    public List<String> getListTextUnderImages() {

        return listTextUnderImages
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public List<WebElement> getFrameWithButton() {

        return this.frameWithButton;
    }

    public List<WebElement> getButtonFromFrameButton() {

        return this.frameButton;


    }

    public void switchToFrameButton() {

        driver.switchTo().frame(this.frameWithButton.get(0));
    }

    public void switchToWindowBack() {

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.titleIs(this.getTitle()));

    }

    public void open(String url) {

        driver.navigate().to(url);;

    }


}

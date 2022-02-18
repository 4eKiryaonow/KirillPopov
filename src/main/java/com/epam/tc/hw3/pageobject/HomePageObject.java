package com.epam.tc.hw3.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends AbstractPageObject {

    @FindBy(xpath = "//div[contains(@class, 'benefits')]//span[contains(@class, 'icons-benefit')]")
    private List<WebElement> listImages;

    @FindBy(xpath = "//div[contains(@class, 'benefits')]//span[contains(@class, 'benefit-txt')]")
    private List<WebElement> listTextUnderImages;

    @FindBy(xpath = "//iframe[@id='frame']")
    private WebElement frameButton;

    public HomePageObject(WebDriver driver) {

        super(driver);
    }

    public String getLoggedUserAsText() {

        return this.header.getLoggedUser().getText();
    }

    public List<WebElement> getListImages() {

        return this.listImages;

    }

    public List<WebElement> getListTextUnderImages() {

        return this.listTextUnderImages;
    }


    public WebElement getFrameButton() {

        return this.frameButton;
    }

    public WebElement getButtonFromFrameButton() {

        return driver.switchTo()
                .frame(this.getFrameButton()).findElement(By.id("frame-button"));


    }

    public void switchToWindowBack() {

        driver.switchTo().parentFrame();
    }








}

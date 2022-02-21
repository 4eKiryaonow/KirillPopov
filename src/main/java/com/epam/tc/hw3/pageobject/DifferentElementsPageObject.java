package com.epam.tc.hw3.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPageObject extends AbstractPageObject {

    @FindBy(xpath = "//div[@class='checkbox-row']/label[contains(., 'Water')]/input")
    private WebElement checkBoxWater;

    @FindBy(xpath = "//div[@class='checkbox-row']/label[contains(., 'Wind')]/input")
    private WebElement checkBoxWind;

    @FindBy(xpath = "//div[@class='checkbox-row']/label[contains(., 'Selen')]/input")
    private WebElement radioSelen;

    @FindBy(css = ".colors > select")
    private WebElement dropDownColors;

    public DifferentElementsPageObject(WebDriver driver) {

        super(driver);
    }

    public void clickCheckBoxWater() {

        wait.until(ExpectedConditions.elementToBeClickable(checkBoxWater)).click();

    }

    public void clickCheckBoxWind() {

        wait.until(ExpectedConditions.elementToBeClickable(checkBoxWind)).click();
    }

    public void clickRadioSelen() {

        wait.until(ExpectedConditions.elementToBeClickable(radioSelen)).click();
    }

    public void selectColor(final String color) {

        Select select = new Select(dropDownColors);
        select.selectByVisibleText(color);

    }


}

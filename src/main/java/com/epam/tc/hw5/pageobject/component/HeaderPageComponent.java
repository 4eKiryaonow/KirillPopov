package com.epam.tc.hw5.pageobject.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPageComponent extends AbstractBaseComponent {

    @FindBy(className = "navbar-right")
    private WebElement dropDownProfileMenu;

    @FindBy(id = "name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement passWord;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement loggedUser;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> navigationMenu;

    @FindBy(className = "dropdown")
    private WebElement serviceDropdown;

    public HeaderPageComponent(WebDriver driver) {

        super(driver);
    }

    public void login(String username, String password) {

        dropDownProfileMenu.click();
        userName.sendKeys(username);
        passWord.sendKeys(password);
        loginButton.click();
    }

    public WebElement getLoggedUser() {

        return loggedUser;
    }

    public List<String> getTitlesNavigationMenu() {

        return navigationMenu
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public void clickByServiceDropDownMenu() {

        wait.until(ExpectedConditions.elementToBeClickable(serviceDropdown))
            .click();
    }

    public void clickByDifferentElements() {

        wait.until(ExpectedConditions.visibilityOf(
            driver.findElement(
                By.xpath("//ul[contains(@class, 'm-l8')]/descendant::ul/descendant::*[text()='Different elements']"))))
            .click();
    }

    public void clickByUserTableButton() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@class, 'm-l8')]/descendant::ul/descendant::*[contains(text(),'User Table')]")))
            .click();
    }
}

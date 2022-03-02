package com.epam.tc.hw4.pageobject.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideBarComponent extends AbstractBaseComponent {

    @FindBy(css = ".left > li")
    private List<WebElement> leftSideBarMenu;

    public LeftSideBarComponent(WebDriver driver) {

        super(driver);
    }

    public List<String> getTitlesLeftMenu() {

        return leftSideBarMenu
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public List<WebElement> getLeftSideBarMenu() {

        return this.leftSideBarMenu;
    }
}

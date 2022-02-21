package com.epam.tc.hw3.pageobject.component;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightSideBarComponent extends AbstractBaseComponent {

    @FindBy(css = ".logs > li")
    private WebElement logPanel;

    public RightSideBarComponent(WebDriver driver) {

        super(driver);

    }

    public List<WebElement> logsList() {

        return logPanel.findElements(By.tagName("li"));

    }
}

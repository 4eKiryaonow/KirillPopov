package com.epam.tc.hw6.pageobject.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightSideBarComponent extends AbstractBaseComponent {

    @FindBy(css = ".logs > li")
    private List<WebElement> logPanel;

    public RightSideBarComponent(WebDriver driver) {

        super(driver);
    }

    public List<String> logsList() {

        return logPanel
            .stream()
            .map(WebElement::getText)
            .map(text -> text.replaceAll("^\\d*[:]\\d*[:]\\d*\\s", "").trim())
            .collect(Collectors.toList());
    }
}

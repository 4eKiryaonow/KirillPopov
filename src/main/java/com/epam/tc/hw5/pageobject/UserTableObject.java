package com.epam.tc.hw5.pageobject;

import com.epam.tc.hw5.pageobject.component.HeaderPageComponent;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTableObject extends AbstractPageObject {

    @FindBy(id = "user-table")
    private WebElement userTable;

    public UserTableObject(WebDriver driver) {

        super(driver);
    }

    public WebElement getUserTable() {

        return userTable;
    }

    public List<WebElement> getDropdowns() {

        return userTable.findElements(By.cssSelector("select"));

    }

    public List<WebElement> getUserNames() {

        return userTable.findElements(By.cssSelector("a"));

    }

    public List<WebElement> getTextUnderImage() {

        return userTable.findElements(By.cssSelector("span"));

    }

    public List<WebElement> getCheckBoxes() {

        return userTable.findElements(By.cssSelector("input"));

    }

    public List<String> getUserInfo() {

        return userTable.findElements(By.cssSelector("tr")).stream().map(WebElement::getText)
                        .collect(Collectors.toList());

    }


}

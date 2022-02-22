package com.epam.tc.hw4.pageobject;

import com.epam.tc.hw4.pageobject.component.HeaderPageComponent;
import com.epam.tc.hw4.pageobject.component.LeftSideBarComponent;
import com.epam.tc.hw4.pageobject.component.RightSideBarComponent;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String title;
    protected HeaderPageComponent header;
    protected LeftSideBarComponent leftSideBar;
    protected RightSideBarComponent rightSideBar;
    protected String url;

    protected AbstractPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.title = this.driver.getTitle();
        PageFactory.initElements(this.driver, this);
        header = new HeaderPageComponent(driver);
        leftSideBar = new LeftSideBarComponent(driver);
        rightSideBar = new RightSideBarComponent(driver);
    }

    public String getTitle() {
        return this.title;
    }

    public HeaderPageComponent header() {
        return this.header;
    }

    public LeftSideBarComponent leftSideBar() {

        return this.leftSideBar;
    }

    public RightSideBarComponent rightSideBar() {

        return this.rightSideBar;
    }

    protected void open(String url) {

        driver.navigate().to(url);
    }
}

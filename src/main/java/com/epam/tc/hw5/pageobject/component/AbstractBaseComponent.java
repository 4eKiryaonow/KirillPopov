package com.epam.tc.hw5.pageobject.component;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractBaseComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;


    protected AbstractBaseComponent(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
    }
}

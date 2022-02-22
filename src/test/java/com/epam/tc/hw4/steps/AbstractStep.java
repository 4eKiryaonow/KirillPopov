package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.PropertiesReader;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep extends PropertiesReader {

    protected WebDriver driver;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
    }
}

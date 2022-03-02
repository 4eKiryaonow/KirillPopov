package com.epam.tc.hw5.step;

import com.epam.tc.hw5.TestData;
import com.epam.tc.hw5.context.TestContext;
import com.epam.tc.hw5.pageobject.DifferentElementsPageObject;
import com.epam.tc.hw5.pageobject.HomePageObject;
import com.epam.tc.hw5.pageobject.UserTableObject;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected DifferentElementsPageObject differentElementsPageObject;
    protected HomePageObject homePageObject;
    protected UserTableObject userTableObject;
    protected TestData testData;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        homePageObject = new HomePageObject(driver);
        differentElementsPageObject = new DifferentElementsPageObject(driver);
        userTableObject = new UserTableObject(driver);
        testData = new TestData();
    }
}

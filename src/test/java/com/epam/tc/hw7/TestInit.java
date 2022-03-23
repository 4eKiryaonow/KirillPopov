package com.epam.tc.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.tc.hw7.pageobject.entities.CredentialData.ROMAN;
import static com.epam.tc.hw7.pageobject.pages.HomePage.loginForm;
import static com.epam.tc.hw7.pageobject.pages.HomePage.userIcon;
import static com.epam.tc.hw7.pageobject.site.JdiTestSite.homePage;

import com.epam.tc.hw7.pageobject.site.JdiTestSite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public interface TestInit {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        logger.setLogLevel(STEP);
        initElements(JdiTestSite.class);
    }

    @BeforeMethod(alwaysRun = true)
    static void openSiteAndLogin() {
        homePage.open();
        userIcon.click();
        loginForm.loginAs(ROMAN);
    }

    @AfterMethod(alwaysRun = true)
    static void logout() {
        homePage.logout();
    }

    @AfterClass(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}

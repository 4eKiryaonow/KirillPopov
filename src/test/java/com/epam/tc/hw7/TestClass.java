package com.epam.tc.hw7;

import static com.epam.tc.hw7.pageobject.pages.HomePage.loginForm;
import static com.epam.tc.hw7.pageobject.pages.HomePage.userIcon;
import static com.epam.tc.hw7.pageobject.sections.Header.metalsAndColors;
import static com.epam.tc.hw7.pageobject.site.JdiTestSite.homePage;

import com.epam.tc.hw7.pageobject.entities.User;
import org.testng.annotations.Test;

public class TestClass implements TestInit {

    public static User ROMAN = new User().set(c -> {
        c.username = "Roman";
        c.password = "Jdi1234";
    });

    @Test
    public void testMethod() {

        homePage.open();
        userIcon.click();
        loginForm.loginAs(ROMAN);
        metalsAndColors.click();

    }
}

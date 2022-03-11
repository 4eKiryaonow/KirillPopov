package com.epam.tc.hw7.pageobject.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.pageobject.pages.HomePage;
import com.epam.tc.hw7.pageobject.pages.MetalsAndColors;
import com.epam.tc.hw7.pageobject.sections.Header;
import com.epam.tc.hw7.pageobject.sections.LoginForm;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestSite {

    public static HomePage homePage;
    public static LoginForm loginForm;
    public static MetalsAndColors metalsAndColors;
    public static Header header;


}

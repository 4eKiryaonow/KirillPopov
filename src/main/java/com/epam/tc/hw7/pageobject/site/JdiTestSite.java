package com.epam.tc.hw7.pageobject.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.tc.hw7.pageobject.pages.HomePage;
import com.epam.tc.hw7.pageobject.pages.MetalsAndColorsPage;
import com.epam.tc.hw7.pageobject.sections.Header;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestSite {

    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;
    public static Header header;
}

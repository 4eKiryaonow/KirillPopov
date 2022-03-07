package com.epam.tc.hw7.pageobject.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.pageobject.sections.LoginForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {

    @Css("form") public static LoginForm loginForm;
    @Css("img#user-icon") public static Icon userIcon;


}

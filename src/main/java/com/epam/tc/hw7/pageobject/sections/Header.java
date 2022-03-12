package com.epam.tc.hw7.pageobject.sections;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;

public class Header {

    @UI("//a[contains(text(), 'Home')]")
    public static Link home;
    @UI("//a[contains(text(), 'Contact form')]")
    public static Link contactForm;
    @UI(".dropdown-toggle")
    public static Dropdown services;
    @UI("//a[contains(text(), 'Metals & Colors')]")
    public static Link metalsAndColors;
}

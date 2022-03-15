package com.epam.tc.hw7.pageobject.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.pageobject.entities.MetalsAndColorsData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsForm> {

    @XPath("//*[@id='odds-selector']/descendant::*[contains(text(), '%s')]/parent::p/input")
    public static RadioButtons oddNumbers;

    @XPath("//*[@id='even-selector']/descendant::*[contains(text(), '%s')]/parent::p/input")
    public static RadioButtons evenNumbers;

    @UI("#calculate-button")
    public static Button calculateButton;

    @UI("//p[@class='checkbox'][contains(., '%s')]//label")
    public static UIElement elements;

    @JDropdown(root = ".colors",
               value = ".pull-left",
               list = "li",
               expand = ".caret")
    public static Dropdown colorsDropDownList;

    @JDropdown(root = ".metals",
               value = ".pull-left",
               list = "li",
               expand = ".caret")
    public static Dropdown metalsDropdownList;

    @JDropdown(root = "#salad-dropdown",
               value = "[data-toggle='dropdown']",
               list = "li",
               expand = ".caret")
    public static Dropdown saladDropDownList;

    @XPath("//*[@id='salad-dropdown']/button")
    public static Button saladButton;

    @UI("#submit-button")
    public static Button submitButton;

    public void fillAllFieldsInForm(MetalsAndColorsData metalsAndColorsData) {

        //fill summary section
        oddNumbers.select(metalsAndColorsData.getSummary().get(0).toString());
        evenNumbers.select(metalsAndColorsData.getSummary().get(1).toString());
        calculateButton.click();

        //fill elements section
        for (String element : metalsAndColorsData.getElements()) {

            elements.select(element);
        }

        //fill color
        colorsDropDownList.select(metalsAndColorsData.getColor());

        //fill metal
        metalsDropdownList.select(metalsAndColorsData.getMetal());

        //fill vegetables
        saladButton.click();
        if (saladDropDownList.selected("Vegetables")) {

            saladDropDownList.select("Vegetables");
        }

        for (String vegetable : metalsAndColorsData.getVegetables()) {

            saladDropDownList.select(vegetable);
        }

        //click submit button
        submitButton.click();
    }
}

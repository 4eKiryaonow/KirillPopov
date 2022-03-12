package com.epam.tc.hw7.pageobject.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.tc.hw7.pageobject.entities.User;

public class LoginForm extends Form<User> {

    @UI("#name")
    TextField login;
    @UI("#password")
    TextField password;
    @UI("#login-button")
    Button loginButton;
}

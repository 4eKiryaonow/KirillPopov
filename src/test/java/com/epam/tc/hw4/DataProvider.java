package com.epam.tc.hw4;

import java.util.List;

public class DataProvider {

    private String username;
    private String password;
    private String userLogged;
    private String title;
    private String url;
    private String color;

    public DataProvider() {

        this.username = PropertiesReader.getProperty("username");
        this.password = PropertiesReader.getProperty("password");
        this.userLogged = PropertiesReader.getProperty("userLogged");
        this.title = PropertiesReader.getProperty("title");
        this.url = PropertiesReader.getProperty("url");
        this.color = PropertiesReader.getProperty("color");
    }

    private List<String> expectedHeaderItems = List.of(
        "HOME",
        "CONTACT FORM",
        "SERVICE",
        "METALS & COLORS"
    );

    private List<String> expectedTextUnderImages = List.of(
        "To include good practices\nand ideas from successful\nEPAM project",
        "To be flexible and\ncustomizable",
        "To be multiplatform",
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
    );

    private List<String> expectedItemsLeftBar = List.of(
        "Home",
        "Contact form",
        "Service",
        "Metals & Colors",
        "Elements packs"
    );

    private List<String> expectedLogRows = List.of(
        "Colors: value changed to Yellow",
        "metal: value changed to Selen",
        "Wind: condition changed to true",
        "Water: condition changed to true"
    );

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserLogged() {
        return userLogged;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getColor() {
        return color;
    }

    public List<String> getExpectedHeaderItems() {
        return expectedHeaderItems;
    }

    public List<String> getExpectedTextUnderImages() {
        return expectedTextUnderImages;
    }

    public List<String> getExpectedItemsLeftBar() {
        return expectedItemsLeftBar;
    }

    public List<String> getExpectedLogRows() {
        return expectedLogRows;
    }
}

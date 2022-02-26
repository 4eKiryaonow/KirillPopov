package com.epam.tc.hw3;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "DataProviderForTests")
    public static Object[][] getDataForFirstEx() {

        TestData data = new TestData();
        data.setUrl(PropertiesReader.getProperty("url"));
        data.setTitle(PropertiesReader.getProperty("title"));
        data.setUsername(PropertiesReader.getProperty("username"));
        data.setPassword(PropertiesReader.getProperty("password"));
        data.setUserLogged(PropertiesReader.getProperty("userLogged"));
        data.setColor(PropertiesReader.getProperty("color"));

        return new Object[][] {{data}};
    }
}

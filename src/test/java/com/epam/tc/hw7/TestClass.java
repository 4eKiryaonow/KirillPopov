package com.epam.tc.hw7;

import static com.epam.tc.hw7.pageobject.entities.CredentialData.ROMAN;
import static com.epam.tc.hw7.pageobject.pages.HomePage.assertUserName;
import static com.epam.tc.hw7.pageobject.pages.MetalsAndColorsPage.metalsAndColorsForm;
import static com.epam.tc.hw7.pageobject.site.JdiTestSite.header;
import static com.epam.tc.hw7.pageobject.site.JdiTestSite.metalsAndColorsPage;

import com.epam.tc.hw7.pageobject.entities.MetalsAndColorsData;
import org.testng.annotations.Test;

public class TestClass implements TestInit {

    @Test(dataProvider = "provider",
          dataProviderClass = DataProviderTest.class)
    public void testMethod(MetalsAndColorsData data) {
        assertUserName(ROMAN);
        header.metalsAndColors.click();
        metalsAndColorsPage.checkOpened();
        metalsAndColorsForm.fillAllFieldsInForm(data);
        metalsAndColorsPage.checkResult(data);
    }
}

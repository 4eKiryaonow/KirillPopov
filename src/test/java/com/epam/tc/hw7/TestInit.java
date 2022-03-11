package com.epam.tc.hw7;



import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;

import com.epam.tc.hw7.pageobject.site.JdiTestSite;
import org.testng.annotations.BeforeMethod;


public interface TestInit {

    @BeforeMethod(alwaysRun = true)
    static void setUp() {
        logger.setLogLevel(STEP);
        initElements(JdiTestSite.class);
    }
}

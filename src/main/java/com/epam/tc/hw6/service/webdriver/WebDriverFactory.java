package com.epam.tc.hw6.service.webdriver;

import com.epam.tc.hw6.service.exception.IllegalBrowserNameException;
import com.epam.tc.hw6.service.exception.WebDriverLaunchTypeException;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

@NoArgsConstructor(access = AccessLevel.NONE)
public class WebDriverFactory {

    private static final String LOCAL_LAUNCH_TYPE = "local";
    private static final String REMOTE_LAUNCH_TYPE = "remote";

    public static WebDriver createDriver(final String launchType, final Browser browser) {

        WebDriver driver;

        if (LOCAL_LAUNCH_TYPE.equalsIgnoreCase(launchType)) {
            driver = createLocalDriver(browser);
        } else if (REMOTE_LAUNCH_TYPE.equalsIgnoreCase(launchType)) {
            driver = createLocalDriver(browser);
        } else {
            throw new WebDriverLaunchTypeException();
        }
        return driver;
    }

    private static WebDriver createLocalDriver(final Browser browser) {

        WebDriver driver;

        switch (browser) {

            case CHROME:
                driver = createLocalChromeDriver();
                break;

            case FIREFOX:
                driver = createLocalFirefoxDriver();
                break;

            default:
                throw new IllegalBrowserNameException();
        }

        return driver;
    }

    private static WebDriver createLocalChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createLocalFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createRemoteDriver(final Browser browser) {

        Capabilities capabilities;

        switch (browser) {

            case CHROME:
                capabilities = createRemoteChromeCapabilities();
                break;

            case FIREFOX:
                capabilities = createRemoteFirefoxCapabilities();
                break;

            default:
                throw new IllegalBrowserNameException();
        }
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.5:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {

            throw new IllegalArgumentException(e);
        }

        return driver;
    }

    private static Capabilities createRemoteChromeCapabilities() {
        ChromeOptions options = new ChromeOptions().addArguments(
            "start-maximized",
            "-disable-dev-shm-usage");

        return options;
    }

    private static Capabilities createRemoteFirefoxCapabilities() {

        return new FirefoxOptions();
    }
}

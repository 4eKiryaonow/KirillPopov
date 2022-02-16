package pageobject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.component.HeaderPageComponent;

public abstract class BasePageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String title;
    protected HeaderPageComponent header;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.title = this.driver.getTitle();
        PageFactory.initElements(this.driver, this);
        header = new HeaderPageComponent(driver);
    }

    public String getTitle() {
        return this.title;
    }


    public HeaderPageComponent header() {
        return this.header;
    }
}

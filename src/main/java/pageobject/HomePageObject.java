package pageobject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends BasePageObject {

    public HomePageObject(WebDriver driver) {

        super(driver);
    }

    public String getLoggedUserAsText() {

        return this.header.getLoggedUser().getText();
    }







}

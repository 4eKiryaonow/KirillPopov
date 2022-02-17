package pageobject.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderPageComponent extends AbstractBaseComponent {

    @FindBy(className = "navbar-right")
    private WebElement dropDownProfileMenu;

    @FindBy(id = "name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement passWord;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement loggedUser;

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li")
    private List<WebElement> navigationMenu;

    @FindBy(className = "dropdown")
    private WebElement serviceDropdown;

    public HeaderPageComponent(WebDriver driver) {

        super(driver);

    }

    public void login(String username, String password) {

        dropDownProfileMenu.click();
        userName.sendKeys(username);
        passWord.sendKeys(password);
        loginButton.click();


    }

    public WebElement getLoggedUser() {

        return loggedUser;
    }

    public List<String> getTitlesNavigationMenu() {

        return navigationMenu
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }

    public void clickByServiceDropDownMenu() {

        wait.until(ExpectedConditions.elementToBeClickable(serviceDropdown))
                .click();

    }

    public void clickByDifferentElements() {

        this.clickByServiceDropDownMenu();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()='Different elements']"))).click();

    }



}

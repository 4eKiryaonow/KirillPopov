package pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPageObject extends AbstractPageObject {

    @FindBy(xpath = "//*[text()[contains(.,'Water')]]/child::input")
    private WebElement checkBoxWater;

    @FindBy(xpath = "//*[text()[contains(.,'Wind')]]/child::input")
    private WebElement checkBoxWind;

    @FindBy(xpath = "//*[text()[contains(.,'Selen')]]/child::input")
    private WebElement radioSelen;

    @FindBy(xpath = "//*[@class='colors']/select")
    private WebElement dropDownColors;

    public DifferentElementsPageObject(WebDriver driver) {

        super(driver);
    }

    public void clickCheckBoxWater() {

        wait.until(ExpectedConditions.elementToBeClickable(checkBoxWater)).click();

    }

    public void clickCheckBoxWind() {

        wait.until(ExpectedConditions.elementToBeClickable(checkBoxWind)).click();
    }

    public void clickRadioSelen() {

        wait.until(ExpectedConditions.elementToBeClickable(radioSelen)).click();
    }

    public void selectColor(final String color) {

        Select select = new Select(dropDownColors);
        select.selectByVisibleText(color);

    }


}

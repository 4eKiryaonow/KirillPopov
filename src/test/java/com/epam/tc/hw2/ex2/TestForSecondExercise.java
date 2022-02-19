package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw2.SeleniumBaseClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestForSecondExercise extends SeleniumBaseClass {


    @Test
    public void testForSecondExercise() {

        //Step 2. Assert Browser title
        wait.until(ExpectedConditions.titleIs("Home Page"));
        assertThat(driver.getTitle()).as("Title home page is wrong").isEqualTo("Home Page");

        //Step 3. Perform login
        WebElement findDropDown = driver.findElement(By.className("navbar-right"));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("navbar-right")));
        findDropDown.click();

        WebElement username = driver.findElement(By.id("name"));
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("Roman");

        WebElement password = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Jdi1234");

        WebElement buttonEnter = driver.findElement(By.id("login-button"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonEnter));
        buttonEnter.click();

        //4. Assert Username is loggined
        WebElement logUsername = driver.findElement(By.id("user-name"));
        wait.until(ExpectedConditions.visibilityOf(logUsername));
        assertThat(logUsername.getText()).as("Username is wrong").isEqualTo("ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        WebElement findService = driver.findElement(By.className("dropdown"));
        wait.until(ExpectedConditions.elementToBeClickable(findService));
        findService.click();
        WebElement findDiffElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ul[contains(@class, 'm-l8')]/descendant::ul/descendant::*[text()='Different elements']")));

        findDiffElement.click();

        //6. Select checkboxes Water, Wind
        WebElement checkBoxWater = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()[contains(.,'Water')]]/child::input")));
        checkBoxWater.click();

        WebElement checkBoxWind = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()[contains(.,'Wind')]]/child::input")));
        checkBoxWind.click();

        //7. Select radio
        WebElement radioSelen = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()[contains(.,'Selen')]]/child::input")));
        radioSelen.click();

        //8. Select in dropdown Yellow
        Select dropDown = new Select(wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//*[@class='colors']/select")))));
        dropDown.selectByVisibleText("Yellow");

        /* 9. Assert that:
        - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        - for radio button there is a log row and value is corresponded to the status of radio button
        - for dropdown there is a log row and value is corresponded to the selected value.
        */
        WebElement logsBody = wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.className("logs"))));
        List<WebElement> logRows = logsBody.findElements(By.tagName("li"));

        assertThat(logRows.get(3).getText())
                .as("Checkbox Water is wrong").contains("Water: condition changed to true");
        assertThat(logRows.get(2).getText())
                .as("Checkbox Wind is wrong").contains("Wind: condition changed to true");
        assertThat(logRows.get(1).getText())
                .as("Radio Selen is wrong").contains("metal: value changed to Selen");
        assertThat(logRows.get(0).getText())
                .as("Checkbox Water is wrong").contains("Colors: value changed to Yellow");

    }
}

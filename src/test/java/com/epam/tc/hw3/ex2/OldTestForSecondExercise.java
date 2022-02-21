package com.epam.tc.hw3.ex2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import com.epam.tc.hw3.SeleniumBaseClass;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OldTestForSecondExercise extends SeleniumBaseClass {


    @Test
    public void testForSecondExercise() {

        //Step 2. Assert Browser title
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
                By.xpath("//div[@class='checkbox-row']/label[contains(., 'Water')]/input")));
        checkBoxWater.click();

        WebElement checkBoxWind = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='checkbox-row']/label[contains(., 'Wind')]/input")));
        checkBoxWind.click();

        //7. Select radio
        WebElement radioSelen = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='checkbox-row']/label[contains(., 'Selen')]/input")));
        radioSelen.click();

        //8. Select in dropdown Yellow
        Select dropDown = new Select(wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.cssSelector(".colors > select")))));
        dropDown.selectByVisibleText("Yellow");

        /* 9. Assert that:
        - for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        - for radio button there is a log row and value is corresponded to the status of radio button
        - for dropdown there is a log row and value is corresponded to the selected value.
        */
        List<WebElement> logRows = driver.findElements(By.cssSelector(".logs > li"));

        List<String> actualLogRows = logRows
                .stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("^\\d*[:]\\d*[:]\\d*\\s", "").trim())
                .collect(Collectors.toList());

        List<String> expectedLogRows = List.of(
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        );

        assertThat(actualLogRows).containsExactlyElementsOf(expectedLogRows);


    }
}

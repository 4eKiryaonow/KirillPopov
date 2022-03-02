package com.epam.tc.hw5.step;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.User;
import com.epam.tc.hw5.UserTable;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep {

    @And("Log rows are displayed in Log Bar")
    public void assertLogRowsInRightSideSection() {

        assertThat(differentElementsPageObject.rightSideBar().logsList())
            .containsExactlyElementsOf(testData.getExpectedLogRows());
    }

    @Then("\"User Table\" page should be opened")
    public void assertBrowserUserTablePage() {

        assertThat(userTableObject.getTitle()).isEqualTo("User Table");
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertNumberOfDropdowns() {

        assertThat(userTableObject.getDropdowns())
            .hasSize(6).allMatch(WebElement::isDisplayed);
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void assertNumberOfUserNames() {

        assertThat(userTableObject.getUserNames())
            .hasSize(6).allMatch(WebElement::isDisplayed);
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void assertNumberTextUnderImage() {

        assertThat(userTableObject.getTextUnderImage())
            .hasSize(6).allMatch(WebElement::isDisplayed);
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void assertNumberOfCheckboxes() {

        assertThat(userTableObject.getCheckBoxes())
            .hasSize(6).allMatch(WebElement::isDisplayed);
    }

    @And("User table should contain following values:")
    public void assertDataValues(DataTable dataTable) {

        UserTable expectedUserTable = new UserTable();

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {

            expectedUserTable.addUser(
                new User(
                    columns.get("Number"),
                    columns.get("User"),
                    columns.get("Description")
                ));

        }
        System.out.println(expectedUserTable);

        System.out.println(userTableObject.getUserInfo());
    }

    @And("droplist should contain values in column Type for user Roman")
    public void assertDataValuesType(DataTable dataTable) {

    }
}

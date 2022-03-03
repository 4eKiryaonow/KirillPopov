package com.epam.tc.hw5.pageobject;

import com.epam.tc.hw5.pageobject.component.HeaderPageComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTableObject extends AbstractPageObject {

    @FindBy(id = "user-table")
    private WebElement userTable;

    @FindBy(css = "table tr")
    private List<String> rows;

    public UserTableObject(WebDriver driver) {

        super(driver);
    }

    public WebElement getUserTable() {

        return userTable;
    }

    public List<WebElement> getDropdowns() {

        return userTable.findElements(By.cssSelector("select"));
    }

    public List<WebElement> getUserNames() {

        return userTable.findElements(By.cssSelector("a"));
    }

    public List<WebElement> getTextUnderImage() {

        return userTable.findElements(By.cssSelector("span"));
    }

    public List<WebElement> getCheckBoxes() {

        return userTable.findElements(By.cssSelector("input"));
    }

    public List<WebElement> getUserInfo() {

        return userTable.findElements(By.cssSelector("tr td"));
    }

    public List<HashMap<String, String>> getUserTableData() {

        List<HashMap<String, String>> listTable = new ArrayList<HashMap<String, String>>();
        List<WebElement> rowElements = userTable.findElements(By.cssSelector("tr"));

        List<String> columnNames = new ArrayList<>();
        List<WebElement> headerElements = rowElements.get(0).findElements(By.cssSelector("th"));

        for (WebElement headerElement : headerElements) {
            columnNames.add(headerElement.getText());
        }

        for (WebElement rowElement : rowElements) {

            HashMap<String, String> row = new HashMap<String, String>();

            int columnIndex = 0;
            List<WebElement> cellElements = rowElement.findElements(By.cssSelector("td"));
            for (WebElement cellElement : cellElements) {
                row.put(columnNames.get(columnIndex), cellElement
                    .getText()
                    .replaceAll("Vip", "")
                    .replaceAll("\n", " ")
                    .trim());
                columnIndex++;
            }

            listTable.add(row);
        }
        listTable.remove(0);

        return listTable;
    }

    public List<String> getValuesDropdownType() {

        return userTable
            .findElements(By.xpath("//tr[contains(., 'Roman')]/td/select/option"))
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    public void clickOnCheckBox(String user) {

        userTable.findElement(By.xpath("//tr[contains(., '" + user + "')]/td/div/input")).click();
    }
}

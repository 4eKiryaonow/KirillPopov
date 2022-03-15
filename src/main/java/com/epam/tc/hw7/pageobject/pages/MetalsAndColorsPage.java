package com.epam.tc.hw7.pageobject.pages;

import static org.hamcrest.Matchers.equalTo;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7.pageobject.entities.MetalsAndColorsData;
import com.epam.tc.hw7.pageobject.sections.MetalsAndColorsForm;
import java.util.List;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    public static MetalsAndColorsForm metalsAndColorsForm;

    @UI(".summ-res")
    private Text summaryResult;

    @UI(".elem-res")
    private Text elementsResult;

    @UI(".col-res")
    private Text colorResult;

    @UI(".met-res")
    private Text metalsResult;

    @UI(".sal-res")
    private Text vegetablesResult;

    private void checkSummaryResult(Integer firstNumber, Integer secondNumber) {
        Integer sum = firstNumber + secondNumber;
        summaryResult.assertThat().text(equalTo(String.format("Summary: %s", sum)));
    }

    private void checkElementsResult(List<String> elements) {
        String elementsRow = String.join(", ", elements);
        elementsResult.assertThat().text(equalTo(String.format("Elements: %s", elementsRow)));
    }

    private void checkColorsResult(String color) {
        colorResult.assertThat().text(equalTo(String.format("Color: %s", color)));
    }

    private void checkMetalsResult(String metal) {
        metalsResult.assertThat().text(equalTo(String.format("Metal: %s", metal)));
    }

    private void checkVegetablesResult(List<String> vegetables) {
        String vegetablesRow = String.join(", ", vegetables);
        vegetablesResult.assertThat().text(equalTo(String.format("Vegetables: %s", vegetablesRow)));
    }

    public void checkResult(MetalsAndColorsData metalsAndColorsData) {
        if ((metalsAndColorsData.getSummary().get(0) != null) && (metalsAndColorsData.getSummary().get(1) != null)) {
            checkSummaryResult(metalsAndColorsData.getSummary().get(0), metalsAndColorsData.getSummary().get(1));
        }
        if (metalsAndColorsData.getElements() != null) {
            checkElementsResult(metalsAndColorsData.getElements());
        }
        if (metalsAndColorsData.getColor() != null) {
            checkColorsResult(metalsAndColorsData.getColor());
        }
        if (metalsAndColorsData.getMetal() != null) {
            checkMetalsResult(metalsAndColorsData.getMetal());
        }
        if (metalsAndColorsData.getVegetables() != null) {
            checkVegetablesResult(metalsAndColorsData.getVegetables());
        }
    }
}

package com.epam.tc.hw7.pageobject.entities;

import com.jdiai.tools.DataClass;
import java.util.List;

public class MetalsAndColorsData extends DataClass<MetalsAndColorsData> {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetables;

    public List<Integer> getSummary() {
        return summary;
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }
}

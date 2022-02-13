package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;

public abstract class TestBaseClass {

    protected Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    void setUp() {

        calculator = new Calculator();

    }
}

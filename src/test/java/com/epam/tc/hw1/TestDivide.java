package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

public class TestDivide extends TestBaseClass {


    @Test(
            groups = "Divide and Multiply",
            dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "Data for divide"
    )
    void testDivideLong(long a, long b, long expected) {

        long result = calculator.div(a, b);
        assertThat(result).as("Divide is wrong").isEqualTo(expected);

    }

    @Test(
            groups = "Divide and Multiply",
            dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "Data for division by zero",
            expectedExceptions = {NumberFormatException.class}
    )
    void testDivideByZero(long a, long b) {

        calculator.div(a, b);


    }
}

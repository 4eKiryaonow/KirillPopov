package com.epam.tc.hw1;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;

public class TestDivide {

    @Test(
            dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "Data for divide"
    )
    void testDivideLong(long a, long b, long expected) {

        Calculator calculator = new Calculator();
        long result = calculator.div(a, b);
        assertThat(result).as("Divide is wrong").isEqualTo(expected);

    }
}

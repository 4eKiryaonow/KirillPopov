package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;


public class TestMultiply extends TestBaseClass {

    @Test(
        groups = {"Divide and Multiply"},
        dataProviderClass = DataProviderForCalculator.class,
        dataProvider = "Data for multiply"

    )
    void testMultiply(long a, long b, long expected) {

        Long result = calculator.mult(a, b);
        assertThat(result).as("Multiply is wrong").isEqualTo(expected);

    }
}

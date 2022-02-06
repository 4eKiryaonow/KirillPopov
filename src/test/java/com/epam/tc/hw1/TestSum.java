package com.epam.tc.hw1;

import static org.assertj.core.api.Java6Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;


public class TestSum {

    @Test(
            dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "Data for sum"
    )
    public void sumTest(long a, long b, long expected) {
        Calculator calculator = new Calculator();
        long actual = calculator.sum(a, b);
        assertThat(actual).as("Sum is wrong").isEqualTo(expected);
    }
}


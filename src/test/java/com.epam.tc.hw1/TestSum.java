package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;


public class TestSum extends TestBaseClass {

    @Test(
        dataProviderClass = DataProviderForCalculator.class,
        dataProvider = "Data for sum"
    )
    public void sumTest(long a, long b, long expected) {

        long actual = calculator.sum(a, b);
        assertThat(actual).as("Sum is wrong").isEqualTo(expected);
    }
}

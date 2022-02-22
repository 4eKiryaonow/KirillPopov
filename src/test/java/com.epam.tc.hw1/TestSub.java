package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;


public class TestSub extends TestBaseClass {

    @Test(
        dataProviderClass = DataProviderForCalculator.class,
        dataProvider = "Data for sub"
    )
    void subTestDouble(long a, long b, long expected) {

        long result = calculator.sub(a, b);
        assertThat(result).as("Sub is wrong").isEqualTo(expected);


    }
}

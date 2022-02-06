package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.withPrecision;
import static org.assertj.core.api.Java6Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.Test;




public class TestSub {

    @Test(
            dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "Data for sub"
    )
    void subTestDouble(long a, long b, long expected) {

        Calculator calculator = new Calculator();
        long result = calculator.sub(a, b);
        assertThat(result).as("Sub is wrong").isEqualTo(expected);


    }
}

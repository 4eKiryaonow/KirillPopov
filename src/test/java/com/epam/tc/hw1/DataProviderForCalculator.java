package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderForCalculator {

    @DataProvider(name = "Data for sum")
    public static Object[][] getTestDataForSum() {
        return new Object[][] {
                {1, 3, 4},
                {2, 5, 7},
                {0, 1, 1},
                {0, 0, 0},
                {-1, 0, -1},
                {0, -9, -9},
                {-1, -1, -2}

        };

    }

    @DataProvider(name = "Data for sub")
    public static Object[][] getTestDataForSub() {
        return new Object[][] {
                {1, 1, 0},
                {2, 1, 1},
                {5, 6, -1},
                {0, 0, 0},
                {-7, 2, -9},
                {-1, -1, 0},
                {-2, 0, -2},
                {2, -5, 7},

        };

    }

    @DataProvider(name = "Data for multiply")
    public static Object[][] getTestDataForMultiply() {
        return new Object[][] {
                {1, 1, 1},
                {2, 1, 2},
                {0, 1, 0},
                {-7, 0, 0},
                {-1, 0, 0},
                {-2, -2, 4},
                {-2, 5, -10},
                {0, 0, 0}

        };

    }

    @DataProvider(name = "Data for divide")
    public static Object[][] getTestDataForDivide() {
        return new Object[][] {
                {1, 1, 1},
                {2, 1, 2},
                {0, 1, 0},
                {6, 2, 3},
                {-6, 2, -3},
                {-2, -2, 1},

        };

    }
}

package com.epam.tc.hw7;

import com.epam.tc.hw7.pageobject.entities.MetalsAndColorsData;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "provider")
    public static Object[][] getDataForTest() {
        List<MetalsAndColorsData> listData = new ArrayList<>(JsonReader.getDataFromJsonFile().values());
        Object[][] objects = new Object[listData.size()][];

        for (int i = 0; i < listData.size(); i++) {

            objects[i] = new Object[1];
            objects[i][0] = listData.get(i);
        }

        return objects;
    }
}

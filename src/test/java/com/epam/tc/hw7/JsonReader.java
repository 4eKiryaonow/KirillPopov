package com.epam.tc.hw7;

import com.epam.tc.hw7.pageobject.entities.MetalsAndColorsData;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonReader {

    public static final String METALS_COLORS_DATA_SET = ".\\src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json";

    public static Map<String, MetalsAndColorsData> getDataFromJsonFile() {
        Map<String, MetalsAndColorsData> dataFromJsonFile;
        Gson gson = new Gson();

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(METALS_COLORS_DATA_SET));
            Type type = new TypeToken<Map<String, MetalsAndColorsData>>() {
            }.getType();
            dataFromJsonFile = gson.fromJson(bufferedReader, type);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return dataFromJsonFile;
    }
}

package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public static List<City> csvReader(String filepath) {
        List<City> cities = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] line;

            while ((line = reader.readNext()) != null) {
                if (line.length < 2) {
                    continue;
                }
                String name = line[0];
                double temp = Double.parseDouble(line[1]);
                cities.add(new City(name, temp));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }
}

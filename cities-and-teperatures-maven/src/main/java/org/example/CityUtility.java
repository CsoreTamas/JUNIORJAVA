package org.example;

import java.util.Comparator;
import java.util.List;

public class CityUtility {
    public static City getHottestTempCity(List<City> cities) {
        return cities.stream()
                //.max((c1, c2) -> Double.compare(c1.getTemperature(), c2.getTemperature()))
                .max(Comparator.comparingDouble(City::getTemperature))
                .orElse(null);
    }

    public static City getLowestTempCity(List<City> cities) {
        return cities.stream()
                //.min((c1, c2) -> Double.compare(c1.getTemperature(), c2.getTemperature()))
                .min(Comparator.comparingDouble(City::getTemperature))
                .orElse(null);
    }

    public static double getAverageTemp(List<City> cities) {
        return cities.stream()
                .mapToDouble(city -> city.getTemperature())
                //.mapToDouble(City::getTemperature)
                .average()
                .orElse(0.0);
    }

    public static City getClosestToAverage(List<City> cities) {
        double average = getAverageTemp(cities);
        return cities.stream()
                .min((c1, c2) -> Double.compare(
                        Math.abs(c1.getTemperature()) - average,
                        Math.abs(c2.getTemperature() - average)
                ))
                .orElse(null);
    }
}

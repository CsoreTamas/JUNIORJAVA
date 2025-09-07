package org.example;

import java.util.List;

public class CityUtility {

    public static City getHottestTempCity(List<City> cities) {
        City highest = cities.getFirst();

        for (City city : cities) {
            if (city.getTemperature() > highest.getTemperature()) {
                highest = city;
            }
        }
        return highest;
    }

    public static City getLowestTempCity(List<City> cities) {
        City lowest = cities.getFirst();

        for (City city : cities) {
            if (city.getTemperature() < lowest.getTemperature()) {
                lowest = city;
            }
        }
        return lowest;
    }

    public static double getAverageTemp(List<City> cities) {
        int counter = 0;
        double sum = 0;
        for (City city : cities) {
            sum += city.getTemperature();
            counter++;
        }
        return sum / counter;
    }

    public static City getClosestToAverage(List<City> cities) {
        double average = getAverageTemp(cities);
        double closest = Math.abs(cities.getFirst().getTemperature() - average);
        City closestCity = cities.getFirst();

        for (City city : cities) {
            double difference = Math.abs(city.getTemperature() - average);
            if (difference < closest) {
                closest = difference;
                closestCity = city;

            }
        }
        return closestCity;
    }
}

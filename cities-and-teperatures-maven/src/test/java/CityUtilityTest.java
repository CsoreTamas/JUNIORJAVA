import org.example.City;
import org.example.CityUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityUtilityTest {

    private List<City> cities;

    @BeforeEach
    void createListOfCities() {
        cities = List.of(
                new City("Budapest", 22),
                new City("Madrid", 25),
                new City("Rome", 30),
                new City("London", 20),
                new City("Munchen", -50)
        );
    }

    @Test
    void shouldGetHottestTempCity() {
        City hottest = CityUtility.getHottestTempCity(cities);
        assertEquals("Rome", hottest.getName());
        assertEquals(30, hottest.getTemperature());
    }

    @Test
    void shouldGetLowestTempCity() {
        City lowest = CityUtility.getLowestTempCity(cities);
        assertEquals("Munchen", lowest.getName());
        assertEquals(-50, lowest.getTemperature());
    }

    @Test
    void shouldGetAverageTempCities() {
        assertEquals(9.4, CityUtility.getAverageTemp(cities));
    }

    @Test
    void shouldGetClosestCityToAverage() {
        assertEquals("London", CityUtility.getClosestToAverage(cities).getName());
        assertEquals(20, CityUtility.getClosestToAverage(cities).getTemperature());
    }
}

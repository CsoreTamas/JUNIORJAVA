import org.example.City;
import org.example.CsvParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsVParserTest {
    @Test
    void shouldReadCsVFiles() {
        List<City> cities = CsvParser.csvReader("src/test/java/test.csv");

        assertEquals("Budapest", cities.getFirst().getName());
        assertEquals(22, cities.getFirst().getTemperature());
        assertEquals("Madrid", cities.get(1).getName());
        assertEquals(25, cities.get(1).getTemperature());
        assertEquals("Rome", cities.get(2).getName());
        assertEquals(30, cities.get(2).getTemperature());
        assertEquals("London", cities.get(3).getName());
        assertEquals(20, cities.get(3).getTemperature());
        assertEquals("Munchen", cities.get(4).getName());
        assertEquals(-50, cities.get(4).getTemperature());
        assertEquals("Hamburg", cities.get(5).getName());
        assertEquals(23, cities.get(5).getTemperature());
        assertEquals("Bukarest", cities.get(6).getName());
        assertEquals(25, cities.get(6).getTemperature());
        assertEquals("New York", cities.get(7).getName());
        assertEquals(40, cities.get(7).getTemperature());
    }
}

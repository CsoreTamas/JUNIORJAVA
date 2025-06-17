import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderTest {
    @Test
    void shouldReadFileCorrectly() throws IOException {
        Path expected = Path.of("/Users/csoretamas/files/employee_hours.csv");
        List<Employee> expectedList = FileReader.reader(expected);

        ArrayList<Employee> result = new ArrayList<>();
        ArrayList<String> days = new ArrayList<>(List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));

        ArrayList<Integer> aliceJohnsonHours = new ArrayList<>(List.of(8, 9, 8, 10, 7));
        Employee aliceJohnson = new Employee("Alice Johnson", "Engineering", days, aliceJohnsonHours);
        result.add(aliceJohnson);

        ArrayList<Integer> bobSmithHours = new ArrayList<>(List.of(7, 6, 8, 8, 7));
        Employee bobSmith = new Employee("Bob Smith", "Marketing", days, bobSmithHours);
        result.add(bobSmith);

        ArrayList<Integer> carolLeeHours = new ArrayList<>(List.of(9, 9, 9, 9, 9));
        Employee carolLee = new Employee("Carol Lee", "Engineering", days, carolLeeHours);
        result.add(carolLee);

        ArrayList<Integer> jasonStathamHours = new ArrayList<>(List.of(8, 8, 8, 0, 2));
        Employee jasonStatham = new Employee("Jason Statham", "IT", days, jasonStathamHours);
        result.add(jasonStatham);

        Assertions.assertEquals(expectedList, result);
    }
}

package third.task;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThirdTaskTest {
    @Test
    void shouldReadFile() throws IOException {
        CsvFileReader reader = new CsvFileReader("src/ThirdTask/persons.csv");

        Set<Person> text = reader.reader();

        Set<Person> personList = Set.of(Person.builder().name("John").age(22).build(),
                Person.builder().name("Eva").age(19).build(),
                Person.builder().name("Mark").age(35).build()
        );
        assertEquals(personList, text);
    }
}

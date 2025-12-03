import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import pojo.Employee;
import writer.JsonWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonWriterTest {
    private List<Employee> employeeList;

    @BeforeEach
    void setup() {
        employeeList = List.of(new Employee("Pista Norbert", 42, "Thief", 353), new Employee("Tomcat", 35, "Thief Hunter", 872364));
    }

    @Test
    void shouldWriteJsonFile(@TempDir Path tempDir) throws IOException {
        File tempFile = tempDir.resolve("employee.json").toFile();

        JsonWriter writer = new JsonWriter(tempFile.getAbsolutePath());
        writer.write(employeeList);

        assertTrue(tempFile.exists());
        assertTrue(tempFile.length() > 0);
    }
}

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    @Test
    void shouldMatch() throws IOException {
        FileLoader testHelper = new FileLoaderTestHelper("idk.json", "json");
        Validator validator = new Validator(testHelper);

        assertTrue(validator.isValid());
    }

    @Test
    void shouldDoesNotMatch() throws IOException {
        FileLoader testHelper = new FileLoaderTestHelper("idk.json", "csv");
        Validator validator = new Validator(testHelper);

        RuntimeException exception = assertThrows(RuntimeException.class, validator::isValid);

        assertEquals("Your file name does not match with the export format", exception.getMessage());

        FileLoader FileLoaderTestHelper = new FileLoaderTestHelper("jsonData json", "json");
        Validator NameFormatValidator = new Validator(FileLoaderTestHelper);

        RuntimeException runtimeException = assertThrows(RuntimeException.class, NameFormatValidator::isValid);

        assertEquals("Your file name does not match with the export format", runtimeException.getMessage());
    }
}

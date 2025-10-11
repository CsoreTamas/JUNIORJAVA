package tests;

import filehandeling.ExportFileValidator;
import filehandeling.InvalidFileFormatException;
import filehandeling.PropertyLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ExportFileValidatorTest {
    @Test
    void shouldMatch() throws IOException {
        PropertyLoader testHelper = new FileLoaderTestHelper("idk.json", "json");
        ExportFileValidator validator = new ExportFileValidator(testHelper);

        assertTrue(validator.isValid());
    }

    @Test
    void shouldDoesNotMatchFormat() throws IOException {
        PropertyLoader testHelper = new FileLoaderTestHelper("idk.json", "csv");
        ExportFileValidator validator = new ExportFileValidator(testHelper);

        InvalidFileFormatException invalidFileFormatException = assertThrows(InvalidFileFormatException.class, validator::isValid);

        assertEquals("Your file name does not match with the export format", invalidFileFormatException.getMessage());

    }

    @Test
    void shouldNotMatch() throws IOException {
        PropertyLoader fileLoaderTestHelper = new FileLoaderTestHelper("jsonData json", "json");

        ExportFileValidator validator = new ExportFileValidator(fileLoaderTestHelper);

        InvalidFileFormatException invalidFileFormatException = assertThrows(InvalidFileFormatException.class, validator::isValid);

        assertEquals("Your file name does not match with the export format", invalidFileFormatException.getMessage());
    }
}

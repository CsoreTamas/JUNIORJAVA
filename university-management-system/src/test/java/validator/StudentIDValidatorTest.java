package validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tables.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentIDValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "01234567, true",
            "0123456, false",
            "012345678, false",
            "' ', false",
            "-12345678, false",
            "abcdefgh, false",
            "1234567q, false"
    })
    void shouldValidateStudentID(String studentID, boolean expected) {
        Enrollable enrollable = new Student("Etelka", studentID, "Math");
        Validator<Enrollable> studentIDValidator = new StudentIDValidator();

        boolean actual = studentIDValidator.isValid(enrollable);

        assertEquals(expected, actual);
    }
}

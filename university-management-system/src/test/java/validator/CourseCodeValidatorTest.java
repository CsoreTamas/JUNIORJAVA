package validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tables.Course;
import tables.Faculty;
import tables.Professor;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseCodeValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "ABC-123, true",
            "AB0-123, false",
            "AB-123, false",
            "ABCD-012, false",
            "BCD-0123, false",
            "ABC-A12, false",
            "abc-123, false",
            "' ', false"
    })
    void shouldValidateCourseCode(String courseCode, boolean expected) {
        Course course = new Course(courseCode, "test", new Professor("Pityu", Faculty.MECHANICAL, 3), new HashSet<>());
        Validator<Course> courseCodeValidator = new CourseCodeValidator();

        boolean actual = courseCodeValidator.isValid(course);

        assertEquals(expected, actual);
    }
}

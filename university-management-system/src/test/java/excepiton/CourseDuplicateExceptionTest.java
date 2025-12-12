package excepiton;


import exception.CourseDuplicateException;
import org.junit.jupiter.api.Test;
import tables.Course;
import tables.Faculty;
import tables.Professor;
import tables.University;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseDuplicateExceptionTest {
    @Test
    void shouldThrowException() {
        University university = University.getInstance();
        Course course = new Course("TST-001", "test", new Professor("Pityu", Faculty.MECHANICAL, 3), new HashSet<>());

        university.offerCourse(course);

        assertThrows(
                CourseDuplicateException.class, ()
                        -> university.offerCourse(course)
        );
    }

    @Test
    void shouldGetCorrectMessage() {
        Course course = new Course("TST-001", "test", new Professor("Pityu", Faculty.MECHANICAL, 3), new HashSet<>());

        CourseDuplicateException exception = new CourseDuplicateException(course);

        assertTrue(exception.getMessage().contains("Course already exists"));
        assertTrue(exception.getMessage().contains(course.toString()));
    }
}

package excepiton;

import exception.StudentDuplicateException;
import org.junit.jupiter.api.Test;
import tables.Enrollable;
import tables.Student;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDuplicateExceptionTest {
    @Test
    void shouldThrowException() {
        Enrollable enrollable = new Student("Etelka", "12345678", "Math");

        assertThrows(
                StudentDuplicateException.class, () -> {
                    throw new StudentDuplicateException(enrollable);
                }
        );
    }

    @Test
    void shouldGetCorrectMessage() {
        Enrollable enrollable = new Student("Etelka", "12345678", "Math");

        StudentDuplicateException exception = new StudentDuplicateException(enrollable);

        assertTrue(exception.getMessage().contains("Student already admitted"));
        assertTrue(exception.getMessage().contains(enrollable.toString()));
    }
}

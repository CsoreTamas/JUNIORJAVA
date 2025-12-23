package excepiton;

import exception.StudentDuplicateException;
import org.junit.jupiter.api.Test;
import tables.Enrollable;
import tables.Student;
import tables.University;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDuplicateExceptionTest {
    @Test
    void shouldThrowException() {
        University university = University.getInstance();
        Enrollable enrollable = new Student("Etelka", "12345678", "Math");

        university.admitEnrollable(enrollable);

        assertThrows(
                StudentDuplicateException.class, () ->
                        university.admitEnrollable(enrollable)
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

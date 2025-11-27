package excepiton;

import exception.ProfessorDuplicateException;
import org.junit.jupiter.api.Test;
import tables.Faculty;
import tables.Professor;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfessorDuplicateExceptionTest {
    @Test
    void shouldThrowException() {
        Professor professor = new Professor("Pityu", Faculty.ENGINEERING, 5);

        assertThrows(
                ProfessorDuplicateException.class, () -> {
                    throw new ProfessorDuplicateException(professor);
                }
        );
    }

    @Test
    void shouldGetCorrectMassage() {
        Professor professor = new Professor("Pityu", Faculty.ENGINEERING, 5);

        ProfessorDuplicateException exception = new ProfessorDuplicateException(professor);

        assertTrue(exception.getMessage().contains("Professor already exists."));
        assertTrue(exception.getMessage().contains(professor.toString()));
    }
}

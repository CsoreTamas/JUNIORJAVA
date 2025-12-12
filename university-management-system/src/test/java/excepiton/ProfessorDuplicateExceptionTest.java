package excepiton;

import exception.ProfessorDuplicateException;
import org.junit.jupiter.api.Test;
import tables.Faculty;
import tables.Professor;
import tables.University;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfessorDuplicateExceptionTest {
    @Test
    void shouldThrowException() {
        University university = University.getInstance();
        Professor professor = new Professor("Pityu", Faculty.ENGINEERING, 5);

        university.hireProfessor(professor);

        assertThrows(
                ProfessorDuplicateException.class, () ->
                        university.hireProfessor(professor)
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

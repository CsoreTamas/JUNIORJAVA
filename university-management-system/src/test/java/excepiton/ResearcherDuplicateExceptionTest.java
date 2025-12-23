package excepiton;

import exception.ResearcherDuplicateException;
import org.junit.jupiter.api.Test;
import tables.Enrollable;
import tables.Researcher;
import tables.University;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResearcherDuplicateExceptionTest {
    @Test
    void shouldThrowException() {
        University university = University.getInstance();
        Enrollable enrollable = new Researcher("Jozsi", "history", 56);

        university.admitEnrollable(enrollable);

        assertThrows(
                ResearcherDuplicateException.class, () ->
                        university.admitEnrollable(enrollable)
        );
    }

    @Test
    void shouldGetCorrectMessage() {
        Enrollable enrollable = new Researcher("Jozsi", "history", 56);

        ResearcherDuplicateException exception = new ResearcherDuplicateException(enrollable);

        assertTrue(exception.getMessage().contains("Researcher already admitted"));
        assertTrue(exception.getMessage().contains(enrollable.toString()));
    }
}

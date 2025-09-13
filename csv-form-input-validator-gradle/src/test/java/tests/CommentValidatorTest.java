package tests;

import org.example.validators.CommentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentValidatorTest {
    private CommentValidator commentValidator;

    @BeforeEach
    void createValidator() {
        commentValidator = new CommentValidator();
    }

    @Test
    void shouldReturnTrueValidComment() {
        assertTrue(commentValidator.isValid(""));
        assertTrue(commentValidator.isValid("         "));
        assertTrue(commentValidator.isValid("_ -!?.$"));
        assertTrue(commentValidator.isValid("azAZ09"));
    }

    @Test
    void shouldReturnFalseInvalidComment() {
        assertFalse(commentValidator.isValid("<>"));
        assertFalse(commentValidator.isValid("@"));
        assertFalse(commentValidator.isValid("SS&#39;&#"));
        assertFalse(commentValidator.isValid("HELLÓ"));
    }

    @Test
    void shouldReturnFalseForNullComment() {
        assertFalse(commentValidator.isValid(null));
    }
}

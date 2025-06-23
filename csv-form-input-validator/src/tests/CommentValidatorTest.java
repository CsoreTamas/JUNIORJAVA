package tests;

import org.junit.jupiter.api.Test;
import validators.CommentValidator;
import validators.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentValidatorTest {
    @Test
    void shouldReturnTrueForValidComment() {
        Validator<String> commentValidator = new CommentValidator();
        assertTrue(commentValidator.isValid(""));
        assertTrue(commentValidator.isValid("     "));
        assertTrue(commentValidator.isValid("_-!.,$"));
    }

    @Test
    void shouldReturnFalseForNonValidComment() {
        Validator<String> commentValidator = new CommentValidator();
        assertFalse(commentValidator.isValid("Hello@"));
        assertFalse(commentValidator.isValid("<idk>"));
        assertFalse(commentValidator.isValid("&#41"));
    }
}

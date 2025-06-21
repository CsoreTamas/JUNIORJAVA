package tests;

import org.junit.jupiter.api.Test;
import validators.CommentValidator;
import validators.EmailValidator;
import validators.UsernameValidator;
import validators.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    void shouldReturnTrueForValidNames() {
        Validator<String> usernameValidator = new UsernameValidator();
        assertTrue(usernameValidator.isValid("Janos123"));
        assertTrue(usernameValidator.isValid("1pityuka83"));
        assertTrue(usernameValidator.isValid("pityuka99"));

    }

    @Test
    void shouldReturnFalseForNonValidNames() {
        Validator<String> usernameValidator = new UsernameValidator();
        assertFalse(usernameValidator.isValid("Pityi.12"));
        assertFalse(usernameValidator.isValid("<gezuka>"));
        assertFalse(usernameValidator.isValid("bela!"));
    }


    @Test
    void shouldReturnTrueForValidEmail() {
        Validator<String> emailValidator = new EmailValidator();
        assertTrue(emailValidator.isValid("jhonasPityike21@idk.com"));
        assertTrue(emailValidator.isValid("JANOS.PAL@macmail.hu"));
        assertTrue(emailValidator.isValid("a@a.hu"));
    }

    @Test
    void shouldReturnFalseForNonValidEmail() {
        Validator<String> emailValidator = new EmailValidator();
        assertFalse(emailValidator.isValid("jhonasPityu@idk.k"));
        assertFalse(emailValidator.isValid("JANOSPAL@.hu"));
        assertFalse(emailValidator.isValid("apple[]gmail.com"));
    }

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

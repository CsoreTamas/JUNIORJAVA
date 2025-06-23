package tests;

import org.junit.jupiter.api.Test;
import validators.EmailValidator;
import validators.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {
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
}

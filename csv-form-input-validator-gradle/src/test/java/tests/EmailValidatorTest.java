package tests;

import org.example.validators.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {
    private EmailValidator emailValidator;

    @BeforeEach
    void createValidator() {
        emailValidator = new EmailValidator();
    }

    @Test
    void shouldReturnTrueValidEmail() {
        assertTrue(emailValidator.isValid("csoretama124123s@idk.ru"));
        assertTrue(emailValidator.isValid("hello.world@example.com"));
        assertTrue(emailValidator.isValid("xy@xy.asd"));
        assertTrue(emailValidator.isValid("HELLO.GOD@IamTheGod.god"));
    }

    @Test
    void shouldReturnFalseInvalidEmail() {
        assertFalse(emailValidator.isValid("csore,tamas@idk.ru"));
        assertFalse(emailValidator.isValid("hello.world@@example.com"));
        assertFalse(emailValidator.isValid("xyxy.asd"));
        assertFalse(emailValidator.isValid("xy@xy.comcom"));
        assertFalse(emailValidator.isValid("xy@xycom"));
    }

    @Test
    void shouldReturnFalseForNullEmail() {
        assertFalse(emailValidator.isValid(null));
    }
}

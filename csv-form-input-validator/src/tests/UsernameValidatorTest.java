package tests;

import org.junit.jupiter.api.Test;
import validators.UsernameValidator;
import validators.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsernameValidatorTest {
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
}

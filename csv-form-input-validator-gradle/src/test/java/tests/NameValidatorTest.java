package tests;

import org.example.validators.UsernameValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NameValidatorTest {
    private UsernameValidator nameValidator;

    @BeforeEach
    void createValidator() {
        nameValidator = new UsernameValidator();
    }

    @Test
    void shouldReturnTrueValidName() {
        assertTrue(nameValidator.isValid("alba"));
        assertTrue(nameValidator.isValid("GEZA"));
        assertTrue(nameValidator.isValid("123"));
        assertTrue(nameValidator.isValid("aKirlayEnVagyok38"));
    }

    @Test
    void shouldReturnFalseInvalidName() {
        assertFalse(nameValidator.isValid(""));
        assertFalse(nameValidator.isValid(" "));
        assertFalse(nameValidator.isValid("jozef.kenedi"));
        assertFalse(nameValidator.isValid("jánosgeza"));
        assertFalse(nameValidator.isValid("janos-geza"));
        assertFalse(nameValidator.isValid("janos_geza"));
        assertFalse(nameValidator.isValid("janos@geza"));
    }

    @Test
    void shouldReturnFalseForNullName() {
        assertFalse(nameValidator.isValid(null));
    }
}

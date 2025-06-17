package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import validators.CommentValidator;
import validators.EmailValidator;
import validators.UsernameValidator;

public class ValidatorTest {
    @Test
    void shouldReturnTrueForValidNames() {
        UsernameValidator usernameValidator = new UsernameValidator();
        Assertions.assertTrue(usernameValidator.isValid("Janos123"));
        Assertions.assertTrue(usernameValidator.isValid("1pityuka83"));
        Assertions.assertTrue(usernameValidator.isValid("pityuka99"));

    }

    @Test
    void shouldReturnFalseForNonValidNames() {
        UsernameValidator usernameValidator = new UsernameValidator();
        Assertions.assertFalse(usernameValidator.isValid("Pityi.12"));
        Assertions.assertFalse(usernameValidator.isValid("<gezuka>"));
        Assertions.assertFalse(usernameValidator.isValid("bela!"));
    }


    @Test
    void shouldReturnTrueForValidEmail() {
        EmailValidator emailValidator = new EmailValidator();
        Assertions.assertTrue(emailValidator.isValid("jhonasPityike21@idk.com"));
        Assertions.assertTrue(emailValidator.isValid("JANOS.PAL@macmail.hu"));
        Assertions.assertTrue(emailValidator.isValid("a@a.hu"));
    }

    @Test
    void shouldReturnFalseForNonValidEmail() {
        EmailValidator emailValidator = new EmailValidator();
        Assertions.assertFalse(emailValidator.isValid("jhonasPityu@idk.k"));
        Assertions.assertFalse(emailValidator.isValid("JANOSPAL@.hu"));
        Assertions.assertFalse(emailValidator.isValid("apple[]gmail.com"));
    }

    @Test
    void shouldReturnTrueForValidComment() {
        // [a-zA-Z0-9 _\-!?.,$]*
        CommentValidator commentValidator = new CommentValidator();
        Assertions.assertTrue(commentValidator.isValid(""));
        Assertions.assertTrue(commentValidator.isValid("     "));
        Assertions.assertTrue(commentValidator.isValid("_-!.,$"));
    }

    @Test
    void shouldReturnFalseForNonValidComment() {
        CommentValidator commentValidator = new CommentValidator();
        Assertions.assertFalse(commentValidator.isValid("Hello@"));
        Assertions.assertFalse(commentValidator.isValid("<idk>"));
        Assertions.assertFalse(commentValidator.isValid("&#41"));
    }
}

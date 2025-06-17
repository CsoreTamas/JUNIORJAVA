package tests;

import inputsanitization.InputSanitization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class InputSanitizationTest {
    @Test
    void shouldSanitizeInput() {
        Assertions.assertEquals("&lt;script&gt;", InputSanitization.sanitize("<script>"));
        Assertions.assertEquals("&quot;hello&#x27;", InputSanitization.sanitize("\"hello'"));
        Assertions.assertEquals("&amp;hello&amp;", InputSanitization.sanitize("&hello&"));
    }

    @Test
    void shouldReturnNullIfEmpty() {
        Assertions.assertEquals("", InputSanitization.sanitize(""));
    }

    @Test
    void shouldReturnTheSameIfSafe() {
        Assertions.assertEquals("ThisisMyName:)", InputSanitization.sanitize("ThisisMyName:)"));
        Assertions.assertEquals("csore.tamas123@gmail.com", InputSanitization.sanitize("csore.tamas123@gmail.com"));
        Assertions.assertEquals("comment!!", InputSanitization.sanitize("comment!!"));
    }
}

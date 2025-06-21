package tests;

import inputsanitization.InputSanitization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InputSanitizationTest {
    @Test
    void shouldSanitizeInput() {
        assertEquals("&lt;script&gt;", InputSanitization.sanitize("<script>"));
        assertEquals("&quot;hello&#x27;", InputSanitization.sanitize("\"hello'"));
        assertEquals("&amp;hello&amp;", InputSanitization.sanitize("&hello&"));
    }

    @Test
    void shouldReturnNullIfEmpty() {
        assertEquals("", InputSanitization.sanitize(""));
    }

    @Test
    void shouldReturnTheSameIfSafe() {
        assertEquals("ThisisMyName:)", InputSanitization.sanitize("ThisisMyName:)"));
        assertEquals("csore.tamas123@gmail.com", InputSanitization.sanitize("csore.tamas123@gmail.com"));
        assertEquals("comment!!", InputSanitization.sanitize("comment!!"));
    }
}

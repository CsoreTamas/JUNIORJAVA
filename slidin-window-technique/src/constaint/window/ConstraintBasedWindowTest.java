package constaint.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConstraintBasedWindowTest {
    @Test
    void shouldGetTheSmallestSubString() {
        String string = "bcbcbbabc";
        assertEquals("abc", ConstraintBasedWindow.getSmallestSubString(string));
    }

    @Test
    void shouldThrowStringIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> ConstraintBasedWindow.getSmallestSubString(""));
    }
}

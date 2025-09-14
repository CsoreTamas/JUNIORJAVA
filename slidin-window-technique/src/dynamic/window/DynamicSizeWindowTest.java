package dynamic.window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicSizeWindowTest {
    private int[] array;

    @BeforeEach
    void createArrayOFNumbers() {
        array = new int[]{2, 1, 2, 5, 3, 2};
    }

    @Test
    void shouldGetCorrectlySubArrayLength() {
        assertEquals(2, DynamicSizeWindow.findSmallestSubArray(array, 7));
        assertEquals(2, DynamicSizeWindow.findSmallestSubArray(array, 8));
    }

    @Test
    void shouldGetZero() {
        assertEquals(0, DynamicSizeWindow.findSmallestSubArray(array, 16));
    }

    @Test
    void shouldThrowArrayEmpty() {
        assertThrows(IllegalArgumentException.class, () -> DynamicSizeWindow.findSmallestSubArray(new int[]{}, 2));
    }

    @Test
    void shouldThrowArrayNull() {
        assertThrows(IllegalArgumentException.class, () -> DynamicSizeWindow.findSmallestSubArray(null, 0));
    }

    @Test
    void shouldThrowSumSmallerThan0() {
        assertThrows(IllegalArgumentException.class, () -> DynamicSizeWindow.findSmallestSubArray(array, 0));
    }
}

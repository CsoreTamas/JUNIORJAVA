package fixed.window;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FixedSizeWindowTest {
    private int[] array;

    @BeforeEach
    void createArrayOfNumbers() {
        array = new int[]{1, 3, 3, 7, 4, 2};
    }

    @Test
    void shouldCalculateWindowSum() {
        assertEquals(14, FixedSizeWindow.getMaxSumSlidingWindow(array, 3));
        assertEquals(11, FixedSizeWindow.getMaxSumSlidingWindow(array, 2));
    }

    @Test
    void shouldThrowKIsZeroOrSmallerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> FixedSizeWindow.getMaxSumSlidingWindow(array, 0));
        assertThrows(IllegalArgumentException.class, () -> FixedSizeWindow.getMaxSumSlidingWindow(array, -1));
    }

    @Test
    void shouldThrowKIsGreaterThanArrayLength() {
        assertThrows(IllegalArgumentException.class, () -> FixedSizeWindow.getMaxSumSlidingWindow(array, 10));
    }

    @Test
    void shouldThrowArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> FixedSizeWindow.getMaxSumSlidingWindow(new int[]{}, 2));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdLargeTaskTest {
    @Test
    void shouldCalculateTribonacciWhenFormIs001() {
        int[] array = {0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] expected = {0, 0, 1, 1, 2, 4, 7, 13, 24, 44};
        Assertions.assertArrayEquals(expected, ThirdLargeTask.calculateTribonacciSequence(array));
    }

    @Test
    void shouldCalculateTribonacciWhenFormIs111() {
        int[] testArray = {1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] expectedArray = {1, 1, 1, 3, 5, 9, 17, 31, 57, 105};
        Assertions.assertArrayEquals(expectedArray, ThirdLargeTask.calculateTribonacciSequence(testArray));
    }

    @Test
    void shouldDoNothingWhenFormIs000() {
        int[] testArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] expectedArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expectedArray, ThirdLargeTask.calculateTribonacciSequence(testArray));
    }

    @Test
    void shouldCalculateTribonacciWhenFormIsMinus111() {
        int[] testArray = {-1, -1, -1, 0, 0, 0, 0, 0, 0, 0};
        int[] expectedArray = {-1, -1, -1, -3, -5, -9, -17, -31, -57, -105};
        Assertions.assertArrayEquals(expectedArray, ThirdLargeTask.calculateTribonacciSequence(testArray));
    }
}

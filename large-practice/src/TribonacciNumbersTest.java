import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TribonacciNumbersTest {
    @Test
    void shouldValid() {
        Assertions.assertTrue(TribonacciNumbers.isValid(4));
        Assertions.assertTrue(TribonacciNumbers.isValid(25));
    }

    @Test
    void shouldNotValid() {
        Assertions.assertFalse(TribonacciNumbers.isValid(3));
        Assertions.assertFalse(TribonacciNumbers.isValid(26));
    }

    @Test
    void shouldCalculateTribonacci() {
        List<Integer> testList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 6, 11, 20, 37, 68, 125));
        Assertions.assertEquals(testList, TribonacciNumbers.calculateTribonacci(10));
    }

    @Test
    void shouldCalculateFibonacci() {
        List<Integer> testList = new ArrayList<>(Arrays.asList(2, 5, 7, 12, 19, 31, 50, 81, 131, 212, 343, 555));
        int[] expected = new int[]{2, 5};
        Assertions.assertEquals(testList, TribonacciNumbers.calculateFibonacci(expected));
    }

    @Test
    void shouldGet16Divisors() {
        List<Integer> testList = new ArrayList<>(Arrays.asList(1, 2, 4, 8, 16));
        Assertions.assertEquals(testList, TribonacciNumbers.ifTheNumber16());
    }
}


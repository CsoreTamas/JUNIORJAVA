import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SecondLargeTaskTest {
    @Test
    void shouldDecideIsValidOrNot() {
        Assertions.assertFalse(SecondLargeTask.isValid(49));
        Assertions.assertFalse(SecondLargeTask.isValid(10_001));
        Assertions.assertTrue(SecondLargeTask.isValid(50));
        Assertions.assertTrue(SecondLargeTask.isValid(10_000));
    }

    @Test
    void shouldCalculatePerfectSquares() {
        ArrayList<Integer> squares = SecondLargeTask.calculatePerfectSquaresUntilNumber(50);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 4, 9, 16, 25, 36, 49));

        Assertions.assertEquals(expected, squares);
    }

    @Test
    void shouldSummingEvery5thNumber() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 4, 9, 16, 25, 36, 49));
        ArrayList<Integer> exp = new ArrayList<>(Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400, 441, 484));

        Assertions.assertEquals(25, SecondLargeTask.summingEvery5thElement(expected));
        Assertions.assertEquals(750, SecondLargeTask.summingEvery5thElement(exp));
    }
}

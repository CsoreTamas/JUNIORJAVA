import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ForthTaskTest {
    @Test
    void shouldIsValid() {
        Assertions.assertTrue(ForthTask.isValid(3));
        Assertions.assertTrue(ForthTask.isValid(12500));
    }

    @Test
    void shouldIsNotValid() {
        Assertions.assertFalse(ForthTask.isValid(2));
        Assertions.assertFalse(ForthTask.isValid(12501));
    }

    @Test
    void shouldCalculateCollatz() {
        List<Integer> expected = new ArrayList<>(List.of(6, 3, 10, 5, 16, 8, 4, 2, 1));
        Assertions.assertEquals(expected, ForthTask.calculateCollatz(6));
    }

    @Test
    void shouldCollatzListSizeMultiplyByTwo() {
        List<Integer> expected = new ArrayList<>(List.of(10, 20, 40, 80, 160, 320, 640, 1280, 2560, 5120));
        List<Integer> collatzList = new ArrayList<>(List.of(12, 6, 3, 10, 5, 16, 8, 4, 2, 1));
        Assertions.assertEquals(expected, ForthTask.makeCollatzSizeMultiplyByTwoList(collatzList));
    }
}

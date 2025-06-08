import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdTaskTest {
    @Test
    void shouldValid() {
        Assertions.assertTrue(ThirdTask.isValid(1));
        Assertions.assertTrue(ThirdTask.isValid(5000));
    }

    @Test
    void shouldNotValid() {
        Assertions.assertFalse(ThirdTask.isValid(0));
        Assertions.assertFalse(ThirdTask.isValid(5001));
    }

    @Test
    void shouldGetNumberDivisors() {
        List<Integer> testList = new ArrayList(Arrays.asList(20, 10, 5, 4, 2, 1));
        Assertions.assertEquals(testList, ThirdTask.getDivisors(20));
    }

    @Test
    void shouldPrime() {
        Assertions.assertTrue(ThirdTask.isPrime(2));
        Assertions.assertTrue(ThirdTask.isPrime(17));
    }

    @Test
    void shouldNotPrime() {
        Assertions.assertFalse(ThirdTask.isPrime(1));
        Assertions.assertFalse(ThirdTask.isPrime(16));
    }

    @Test
    void shouldGetTheClosestPrime() {
        Assertions.assertEquals(19, ThirdTask.getClosestPrime(18));
        Assertions.assertEquals(5, ThirdTask.getClosestPrime(4));
    }

    @Test
    void shouldPerfectlyCalculateIceCreamPrice() {
        Assertions.assertEquals(2750, ThirdTask.calculateIceCreamPrice(10));
        Assertions.assertEquals(275, ThirdTask.calculateIceCreamPrice(1));
        Assertions.assertEquals(1375000, ThirdTask.calculateIceCreamPrice(5000));
    }

    @Test
    void shouldCalculateVolumeOfCube() {
        Assertions.assertEquals(125L, ThirdTask.calculateVolumeOfCube(5));
        Assertions.assertEquals(1L, ThirdTask.calculateVolumeOfCube(1));
        Assertions.assertEquals(125000000000L, ThirdTask.calculateVolumeOfCube(5000));
    }

    @Test
    void shouldPerfectCube() {
        Assertions.assertTrue(ThirdTask.isPerfectCube(9));
        Assertions.assertTrue(ThirdTask.isPerfectCube(125));
    }

    @Test
    void shouldNotPerfectCube() {
        Assertions.assertFalse(ThirdTask.isPerfectCube(8));
        Assertions.assertFalse(ThirdTask.isPerfectCube(600));
    }

    @Test
    void shouldChangeHufToEur() {
        Assertions.assertEquals((double) 1.0F, ThirdTask.changeToEur(340), 0.01);
        Assertions.assertEquals(14.7, ThirdTask.changeToEur(5000), 0.01);
    }
}

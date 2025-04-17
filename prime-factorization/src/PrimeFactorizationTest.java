import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizationTest {

    @Test
    void shouldDivisibleByTwo() {
        PrimeFactorization.isDivisibleByTwo(8);
        Assertions.assertEquals(3, PrimeFactorization.primes.size());
    }

    @Test
    void shouldDivisibleByOddNumbers() {
        PrimeFactorization.clearPrimeList();
        PrimeFactorization.addPrimesToList(15);
        Assertions.assertEquals(2, PrimeFactorization.primes.size());
    }

    @Test
    void shouldBeGreaterThenTwoAndPrime() {
        PrimeFactorization.clearPrimeList();
        PrimeFactorization.addRemainingPrimeToList(11);
        PrimeFactorization.addRemainingPrimeToList(3);
        PrimeFactorization.addRemainingPrimeToList(113);
        Assertions.assertEquals(3, PrimeFactorization.primes.size());
    }

    @Test
    void shouldGetAllDivisorPrimes() {
        List<Integer> expectedPrimes = new ArrayList<>();
        expectedPrimes.add(2);
        expectedPrimes.add(2);
        expectedPrimes.add(5);
        expectedPrimes.add(5);
        PrimeFactorization.clearPrimeList();
        PrimeFactorization.printPrimes(100);
        Assertions.assertEquals(expectedPrimes, PrimeFactorization.primes);
    }
}

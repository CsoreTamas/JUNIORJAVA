import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeUtilsTest {
    @Test
    void shouldBePrime() {
        assertTrue(PrimeUtils.isPrime(2));
        assertTrue(PrimeUtils.isPrime(3));
        assertTrue(PrimeUtils.isPrime(17));
    }

    @Test
    void shouldNotBePrime() {
        assertFalse(PrimeUtils.isPrime(0));
        assertFalse(PrimeUtils.isPrime(1));
        assertFalse(PrimeUtils.isPrime(4));
    }

    @Test
    void shouldBePrimeSqrt() {
        assertTrue(PrimeUtils.sqrtIsPrime(2));
        assertTrue(PrimeUtils.sqrtIsPrime(3));
        assertTrue(PrimeUtils.sqrtIsPrime(17));
    }

    @Test
    void shouldNotBePrimeSqrt() {
        assertFalse(PrimeUtils.sqrtIsPrime(0));
        assertFalse(PrimeUtils.sqrtIsPrime(1));
        assertFalse(PrimeUtils.sqrtIsPrime(4));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrimeFactorizationTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11})
    void shouldBeTrueCauseItsPrime(int number) {
        Assertions.assertTrue(PrimeFactorization.isPrime(number));
    }
    @ParameterizedTest
    @ValueSource(ints = {4, 0, 6,1})
    void shouldBeFalseCauseItsNotPrime(int number) {
        Assertions.assertFalse(PrimeFactorization.isPrime(number));
    }

    @Test
    void shouldDivisibleByTwo(){
        PrimeFactorization.isDivisibleByTwo(8);
        Assertions.assertEquals(3,PrimeFactorization.getPrimes.size());
    }

    @Test
    void shouldDivisibleByOddNumbers(){
        PrimeFactorization.clearPrimeList();
        PrimeFactorization.isDivisibleByOddNumbers(15);
        Assertions.assertEquals( 2,PrimeFactorization.getPrimes.size());
    }

    @Test
    void shouldBeGreaterThenTwoAndPrime(){
        PrimeFactorization.clearPrimeList();
        PrimeFactorization.isGreaterThanTwoPrime(11);
        PrimeFactorization.isGreaterThanTwoPrime(3);
        PrimeFactorization.isGreaterThanTwoPrime(113);
        Assertions.assertEquals(3,PrimeFactorization.getPrimes.size());
    }
}

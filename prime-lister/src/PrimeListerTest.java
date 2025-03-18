import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeListerTest {

    @Test
    void numberShouldBetween2and2_000_000_000() {
        //given
        int zero = 0;
        int twoTrillionAndOne = 2_000_000_001;
        int one = 1;
        int two = 2;
        int number = 1_999_999_999;
        int twoTrillion = 2_000_000_000;
        //when
        boolean zeroResult = PrimeLister.isValidNumberFromTheUser(zero);
        boolean twoTrillionAndOneResult = PrimeLister.isValidNumberFromTheUser(twoTrillionAndOne);
        boolean oneResult = PrimeLister.isValidNumberFromTheUser(one);
        boolean twoResult = PrimeLister.isValidNumberFromTheUser(two);
        boolean numberResult = PrimeLister.isValidNumberFromTheUser(number);
        boolean twoTrillionResult = PrimeLister.isValidNumberFromTheUser(twoTrillion);
        //than
        Assertions.assertFalse(zeroResult);
        Assertions.assertFalse(twoTrillionAndOneResult);
        Assertions.assertFalse(oneResult);
        Assertions.assertTrue(twoResult);
        Assertions.assertTrue(numberResult);
        Assertions.assertTrue(twoTrillionResult);
    }
@Test
    void numbersShouldBePrime() {
        //given
        int minusOne = -1;
        int one = 1;
        int four = 4;
        int two = 2;
        int seventeen = 17;
        int twentyNine = 29;
        //when
        boolean minusOneResult = PrimeLister.isPrime(minusOne);
        boolean oneResult = PrimeLister.isPrime(one);
        boolean fourResult = PrimeLister.isPrime(four);
        boolean twoResult = PrimeLister.isPrime(two);
        boolean seventeenResult = PrimeLister.isPrime(seventeen);
        boolean twentyNineResult = PrimeLister.isPrime(twentyNine);
        //than
        Assertions.assertFalse(minusOneResult);
        Assertions.assertFalse(oneResult);
        Assertions.assertFalse(fourResult);
        Assertions.assertTrue(twoResult);
        Assertions.assertTrue(seventeenResult);
        Assertions.assertTrue(twentyNineResult);
    }


}

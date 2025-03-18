import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimeListerTest {

    @Test
    void numberShouldBetween2and2_000_000_000() {
        //given
        int zero = 0;
        int twoBillionAndOne = 2_000_000_001;
        int one = 1;
        int two = 2;
        int number = 1_999_999_999;
        int twoTrillion = 2_000_000_000;
        //when
        boolean zeroResult = PrimeLister.isValidNumber(zero);
        boolean twoBillionAndOneResult = PrimeLister.isValidNumber(twoBillionAndOne);
        boolean oneResult = PrimeLister.isValidNumber(one);
        boolean twoResult = PrimeLister.isValidNumber(two);
        boolean numberResult = PrimeLister.isValidNumber(number);
        boolean twoTrillionResult = PrimeLister.isValidNumber(twoTrillion);
        //than
        Assertions.assertFalse(zeroResult);
        Assertions.assertFalse(twoBillionAndOneResult);
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
        int twentyFive = 25;
        int fortyNine = 49;
        //when
        boolean minusOneResult = PrimeLister.isPrime(minusOne);
        boolean oneResult = PrimeLister.isPrime(one);
        boolean fourResult = PrimeLister.isPrime(four);
        boolean twoResult = PrimeLister.isPrime(two);
        boolean seventeenResult = PrimeLister.isPrime(seventeen);
        boolean twentyNineResult = PrimeLister.isPrime(twentyNine);
        boolean twentyFiveResult = PrimeLister.isPrime(twentyFive);
        boolean fortyNineResult = PrimeLister.isPrime(fortyNine);

        //than
        Assertions.assertFalse(minusOneResult);
        Assertions.assertFalse(oneResult);
        Assertions.assertFalse(fourResult);
        Assertions.assertTrue(twoResult);
        Assertions.assertTrue(seventeenResult);
        Assertions.assertTrue(twentyNineResult);
        Assertions.assertFalse(twentyFiveResult);
        Assertions.assertFalse(fortyNineResult);
    }


}

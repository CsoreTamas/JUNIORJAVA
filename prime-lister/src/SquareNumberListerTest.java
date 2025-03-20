import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareNumberListerTest {

    @Test
    void numbersShouldBeSquare() {
        //given
        int one = 1;
        int four = 4;
        int twentyFive = 25;
        int two = 2;
        int five = 5;
        int eight = 8;
        //when
        boolean oneResult = SquareNumberLister.isSquareRoot(one);
        boolean fourResult = SquareNumberLister.isSquareRoot(four);
        boolean twentyFiveResult = SquareNumberLister.isSquareRoot(twentyFive);
        boolean twoResult = SquareNumberLister.isSquareRoot(two);
        boolean fiveResult = SquareNumberLister.isSquareRoot(five);
        boolean eightResult = SquareNumberLister.isSquareRoot(eight);
        //than
        Assertions.assertTrue(oneResult);
        Assertions.assertTrue(fourResult);
        Assertions.assertTrue(twentyFiveResult);
        Assertions.assertFalse(twoResult);
        Assertions.assertFalse(fiveResult);
        Assertions.assertFalse(eightResult);
    }
}

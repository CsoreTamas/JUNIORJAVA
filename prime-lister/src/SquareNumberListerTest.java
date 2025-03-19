import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Result;

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
        boolean oneResult = SquareNumberLister.isSquareNumber(one);
        boolean fourResult = SquareNumberLister.isSquareNumber(four);
        boolean twentyFiveResult = SquareNumberLister.isSquareNumber(twentyFive);
        boolean twoResult = SquareNumberLister.isSquareNumber(two);
        boolean fiveResult = SquareNumberLister.isSquareNumber(five);
        boolean eightResult = SquareNumberLister.isSquareNumber(eight);
        //than
        Assertions.assertTrue(oneResult);
        Assertions.assertTrue(fourResult);
        Assertions.assertTrue(twentyFiveResult);
        Assertions.assertFalse(twoResult);
        Assertions.assertFalse(fiveResult);
        Assertions.assertFalse(eightResult);
    }
}

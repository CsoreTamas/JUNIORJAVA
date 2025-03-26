import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StrangePolynomialSumMediumTest {

    @Test
    void shouldCalculateCorrectTermForGivenNumber() {

        //given
        int zero = 0;
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;

        //when
        int zeroResult = StrangePolynomialSumMedium.calculateTerm(zero);
        int oneResult = StrangePolynomialSumMedium.calculateTerm(one);
        int twoResult = StrangePolynomialSumMedium.calculateTerm(two);
        int threeResult = StrangePolynomialSumMedium.calculateTerm(three);
        int fourResult = StrangePolynomialSumMedium.calculateTerm(four);

        //then
        Assertions.assertEquals(0, zeroResult);
        Assertions.assertEquals(1, oneResult);
        Assertions.assertEquals(4, twoResult);
        Assertions.assertEquals(27, threeResult);
        Assertions.assertEquals(256, fourResult);

    }
}

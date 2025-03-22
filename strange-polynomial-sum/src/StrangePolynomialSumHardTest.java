import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StrangePolynomialSumHardTest {

    @Test
    void shouldCalculateCorrectTermForGivenNumber() {
        //given
        int six = 6;
        int twelve = 12;
        int eighteen = 18;
        int twentyFour = 24;
        int thirty = 30;
        //when
        int sixResult = StrangePolynomialSumHard.calculateTheNumberResult(six);
        int twelveResult = StrangePolynomialSumHard.calculateTheNumberResult(twelve);
        int eighteenResult = StrangePolynomialSumHard.calculateTheNumberResult(eighteen);
        int twentyFourResult = StrangePolynomialSumHard.calculateTheNumberResult(twentyFour);
        int thirtyResult = StrangePolynomialSumHard.calculateTheNumberResult(thirty);
        //than
        Assertions.assertEquals(-876, sixResult);
        Assertions.assertEquals(-13212, twelveResult);
        Assertions.assertEquals(-1674, eighteenResult);
        Assertions.assertEquals(-118320, twentyFourResult);
        Assertions.assertEquals(-1171800, thirtyResult);
    }

}

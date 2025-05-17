import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StrangePolynomialSumDifficultTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void numbersSmallerThanOneShouldBeTrue(int number) {
        //given , when
        boolean result = StrangePolynomialSumDifficult.isSmallerThanOne(number);
        //then
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void numbersAreGreaterThanOneShouldBeFalse(int number) {
        //given , when
        boolean result = StrangePolynomialSumDifficult.isSmallerThanOne(number);
        //then
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({"2,0,4", "3,0,27", "2,2,6"})
    void shouldDecideSquareOrCube(int i, int partNumber, int expected) {
        //given , when
        int result = StrangePolynomialSumDifficult.calculatePartNumber(i, partNumber);
        //then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    //i, result , expected
    @CsvSource({"4,7,3", "10,20,10", "13,2,15", "4,0,-4"})
    void shouldDecideAddOrSubWhenDivisibleByThreeOrSix(int i, int number, int expected) {
        //given, when
        int result = StrangePolynomialSumDifficult.calculateSum(i, number);
        //then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    //i , partNumber, expected
    @CsvSource({"5,5,10", "10,12,24"})
    void shouldMultiplyByTwoWhenDivisibleByFive(int i, int partNumber, int expected) {
        //given , when
        int result = StrangePolynomialSumDifficult.handleMultipleOfFive(i, partNumber);
        //then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    //i , result, partNumber, expected
    @CsvSource({"2, 10, 5, 5", "3, 10, 10, 20"})
    void shouldDecideAddOrSubWhenDivisibleByTwo(int i, int partNumber, int result, int expected) {
        //given , when
        int finalResult = StrangePolynomialSumDifficult.isDivisibleByTwo(i, partNumber, result);
        //then
        Assertions.assertEquals(expected, finalResult);
    }

    @ParameterizedTest
    //i, result, expected
    @CsvSource({"10,10,0", "25,25,50"})
    void shouldDecideAddOrSubWhenDivisibleByThirty(int i, int result, int expected) {
        //given, when
        int finalResult = StrangePolynomialSumDifficult.isDivisibleByThirty(i, result);
        //then
        Assertions.assertEquals(expected, finalResult);
    }

    @ParameterizedTest
    //result, number, expected
    @CsvSource({"2,2,4", "10,10,100"})
    void shouldMultiplyByTwo(int number, int result, int expected) {
        //given , when
        int finalResult = StrangePolynomialSumDifficult.calculateFinalResult(number, result);
        //then
        Assertions.assertEquals(expected, finalResult);
    }

}
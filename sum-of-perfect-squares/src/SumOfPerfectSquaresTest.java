import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SumOfPerfectSquaresTest {
    @ParameterizedTest
    @ValueSource(ints = {-3, -2, -1, 0})
    void numbersAreSmallerThanOneShouldBeTrue(int number) {
        //given, when
        boolean result = SumOfPerfectSquares.isSmallerThanOne(number);
        //then
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void numbersAreGreaterThanOneShouldBeFalse(int number) {
        //given, when
        boolean result = SumOfPerfectSquares.isSmallerThanOne(number);
        //then
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 5", "3, 14", "4, 30", "5, 55"})
    void shouldCorrectlyCalculateTheSumOfSquares(int number, int expected) {
        //given, when
        int result = SumOfPerfectSquares.getNumbersSquaresSum(number);
        //then
        Assertions.assertEquals(expected, result);
    }
}

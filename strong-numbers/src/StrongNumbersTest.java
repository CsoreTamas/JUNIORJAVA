import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StrongNumbersTest {

    @ParameterizedTest
    @CsvSource({"1,1", "3,6", "4,24", "5,120"})
    void shouldPerfectlyCalculateFactorials(int number, int expected) {
        //given, when
        int result = StrongNumbers.factorial(number);
        //then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"1,1,2", "2,2,4", "10, 10, 20", "32,8,40"})
    void shouldPerfectlyCalculateAdditions(int number, int result, int expected) {
        //given, when
        int finalResult = StrongNumbers.calculateFinalAddition(number, result);
        //then
        Assertions.assertEquals(expected, finalResult);
    }

    @ParameterizedTest
    @CsvSource({"145,145", "1,1"})
    void shouldBeTrue(int number, int result) {
        //given, when
        boolean finalResult = StrongNumbers.decideTrueOrNot(number, result);
        //then
        Assertions.assertTrue(finalResult);
    }

    @ParameterizedTest
    @CsvSource({"146,745", "57,5160"})
    void shouldBeFalse(int number, int result) {
        //given, when
        boolean finalResult = StrongNumbers.decideTrueOrNot(number, result);
        //then
        Assertions.assertFalse(finalResult);
    }
}

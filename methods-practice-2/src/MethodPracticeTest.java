
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class MethodPracticeTest {
    @ParameterizedTest
    @CsvSource({"-100, -30", "100 , 30", "200,60 "})
    void shouldReturnNumber30Percent(int number, double expected) {
        //given when
        double result = MethodPractice.getNumber30Percent(number);
        //then
        Assertions.assertEquals(expected, result);
    }

    // 4.
    @Test
    void shouldReturnAnEmptyString() {
        //given
        String[] strings = {"Hello, Welcome, Good by"};
        //when
        String result = MethodPractice.getAnEmptyString(strings);
        //then
        Assertions.assertEquals("", result);
    }

    // 5.
    @ParameterizedTest
    @CsvSource({"100, 42.8", "200, 85.6"})
    void shouldReturnNumber42Point8Percent(int number, double expected) {
        double result = MethodPractice.getANumber42Point8Percent(number);
        Assertions.assertEquals(expected, result);
    }

    // 6.
    @ParameterizedTest
    @CsvSource({"Hello, 10", "1, 2"})
    void shouldGetStringsLengthMultiplyByTwo(String strings, int expected) {
        int result = MethodPractice.multiplyTheStringLengthByTwo(strings);
        Assertions.assertEquals(expected, result);
    }

    // 7.
    @ParameterizedTest
    @CsvSource({"10,20,10", "0,0,0", "-5,5,10"})
    void shouldGetTheDifferenceOf2Number(int secondNumber, int firstNumber, int expected) {
        int result = MethodPractice.getTheDifference(secondNumber, firstNumber);
        Assertions.assertEquals(expected, result);
    }

    // 8.
    @ParameterizedTest
    @CsvSource({"HelloHell, 3"})
    void shouldGetTheStringLengthSquareRoot(String string, double expected) {
        double result = MethodPractice.getTheStringLengthSquareRoot(string);
        Assertions.assertEquals(expected, result);
    }

    // 9.
    @ParameterizedTest
    @CsvSource({"World, 120", "good, 24"})
    void shouldGetTheStringLengthFactorial(String string, int expected) {
        int result = MethodPractice.getTheStringLengthFactorial(string);
        Assertions.assertEquals(expected, result);
    }

    // 10.
    @ParameterizedTest
    @CsvSource({"100,1", "40,2.5", "-50,-2"})
    void shouldGetNumberDividedBy100(int number, double expected) {
        double result = MethodPractice.division100WithNumber(number);
        Assertions.assertEquals(expected, result);
    }

    // 11.
    @ParameterizedTest
    @CsvSource({"3,9", "4,8", "21,63", "-4,-8"})
    void shouldGetCorrectNumber(int number, int expected) {
        int result = MethodPractice.getANumberIf(number);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6})
    void shouldDecideIsPrimeOrNot(int number) {
        boolean result = MethodPractice.isPrime(number);
        Assertions.assertFalse(result);
    }

    // 12.
    @Test
    void shouldReturnStringsLengthInAnArray() {
        String[] strings = {"Hello", "Good", "Bad", "Awesome"};
        int[] length = {5, 4, 3, 7};
        int[] result = MethodPractice.getTheStringsLength(strings);
        Assertions.assertArrayEquals(length, result);
    }

    // 13.
    @ParameterizedTest
    @CsvSource({"100,15", "200,30"})
    void shouldReturn15Percent(double number, double expected) {
        double result = MethodPractice.calculatePersonalIncomeTax(number);
        Assertions.assertEquals(expected, result);

    }

    @ParameterizedTest
    @CsvSource({"100,18.5"})
    void shouldReturn18Point5Percent(double number, double expected) {
        double result = MethodPractice.calculateSocialSecurityTax(number);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"100_000,66500"})
    void shouldReturnHungarianNetSalary(double number, double expected) {
        double result = MethodPractice.calculateNetSalary(number);
        Assertions.assertEquals(expected, result);
    }

    // 14.
    @ParameterizedTest
    @MethodSource("provideValues")
    void shouldTurnTrue(boolean[] array) {
        boolean result = MethodPractice.decideTrueOrFalse(array);
        Assertions.assertTrue(result);
    }

    public static Stream<Arguments> provideValues() {
        return Stream.of(
                Arguments.of(new boolean[]{true, true, false, true, false}, true),
                Arguments.of(new boolean[]{false, false, true, false, true, true}, true)
        );
    }

    // 15.
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void shouldFillTheArrayWithNumbersUnder0(int[] array, int[] expected) {
        int[] result = MethodPractice.filWithNumbersUnder0(array);
        Assertions.assertArrayEquals(expected, result);
    }

    public static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(new int[]{-1, -3, -100, 5, 6, 4, -9}, new int[]{-1, -3, -100, -9}),
                Arguments.of(new int[]{-1, 3, 100, 5, 6, -4, 9}, new int[]{-1, -4})
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void shouldDecideIsSmallerThan0(int number) {
        boolean result = MethodPractice.isSmallerThan0(number);
        Assertions.assertFalse(result);
    }

    @Test
    void shouldCountNumbersWhichSmallerThan0() {
        int[] array = {-1, -2, -3, 0, 1, 2, 3};
        int result = MethodPractice.countElements(array);
        Assertions.assertEquals(3, result);
    }
}


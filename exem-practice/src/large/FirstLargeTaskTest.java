import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstLargeTaskTest {
    @Test
    void shouldDecideIsValidOrNot() {
        Assertions.assertTrue(FirstLargeTask.isValid(20));
        Assertions.assertTrue(FirstLargeTask.isValid(1000000));
        Assertions.assertFalse(FirstLargeTask.isValid(19));
        Assertions.assertFalse(FirstLargeTask.isValid(1000001));
    }

    @Test
    void shouldCalculateFactorialsUntilNumber() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 6, 24, 120));

        ArrayList<Integer> factorials = FirstLargeTask.calculateFactorialsUntilNumber(121);

        Assertions.assertEquals(expected.size(), factorials.size());
        Assertions.assertEquals(expected, factorials);

        ArrayList<Integer> exp = new ArrayList<>();
        ArrayList<Integer> minFactorial = FirstLargeTask.calculateFactorialsUntilNumber(1);

        Assertions.assertEquals(exp.size(), minFactorial.size());
        Assertions.assertEquals(exp, minFactorial);

        ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 6, 24, 120, 720, 5040, 40320, 362880));


        ArrayList<Integer> maxFactorial = FirstLargeTask.calculateFactorialsUntilNumber(1000000);

        Assertions.assertEquals(expectedList.size(), maxFactorial.size());
        Assertions.assertEquals(expectedList, maxFactorial);
    }

    @Test
    void shouldSumEveryTwoElements() {
        ArrayList<Integer> minExpected = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 6, 24, 120));
        ArrayList<Integer> maxExpected = new ArrayList<>(Arrays.asList(1, 2, 6, 24, 120, 720, 5040, 40320, 362880));

        Assertions.assertEquals(0, FirstLargeTask.calculateTheSumOfEveryTwoFactorials(minExpected));
        Assertions.assertEquals(127, FirstLargeTask.calculateTheSumOfEveryTwoFactorials(expected));
        Assertions.assertEquals(368047, FirstLargeTask.calculateTheSumOfEveryTwoFactorials(maxExpected));
    }
}

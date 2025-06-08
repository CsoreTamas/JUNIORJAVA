import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FifthTaskTest {
    @Test
    void shouldIsValid() {
        Assertions.assertTrue(FifthTask.isValid(5));
        Assertions.assertTrue(FifthTask.isValid(15000));
    }

    @Test
    void shouldIsNotValid() {
        Assertions.assertFalse(FifthTask.isValid(4));
        Assertions.assertFalse(FifthTask.isValid(15001));
    }

    @Test
    void shouldCalculateReciprocalSumOfSquares() {
        Assertions.assertEquals(1.0625, FifthTask.calculateReciprocalSumOfSquaresTillNumber(5));
        Assertions.assertEquals(1.0748456790123457, FifthTask.calculateReciprocalSumOfSquaresTillNumber(10));
    }

    @Test
    void shouldCalculateReciprocalSumTendingInfinity() {
        Assertions.assertEquals(1.6449340668482264, FifthTask.calculateReciprocalSumTendingInfinity());
    }
}

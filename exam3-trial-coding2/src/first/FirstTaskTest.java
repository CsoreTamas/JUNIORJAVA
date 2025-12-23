package first;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTaskTest {
    @Test
    void shouldGetNumbersAboveThreshold() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> actual = FirstTask.getNumsAboveThreshold(nums, 4);

        List<Integer> expectedList = List.of(4, 5, 6, 7, 8, 9, 10);

        assertEquals(expectedList, actual);
    }

    @Test
    void shouldHandleNegativeNumbers() {
        List<Integer> nums = List.of(-2, 0, 43, -53, 21, 2, 0);

        List<Integer> actual = FirstTask.getNumsAboveThreshold(nums, 21);

        List<Integer> expected = List.of(43, 21);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleDuplicatedNumbers() {
        List<Integer> nums = List.of(-2, 0, 43, -53, 21, 2, 0, 21, 43);

        List<Integer> actual = FirstTask.getNumsAboveThreshold(nums, 21);

        List<Integer> expected = List.of(43, 21, 21, 43);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleEmptyList() {
        List<Integer> nums = List.of();

        List<Integer> actual = FirstTask.getNumsAboveThreshold(nums, 21);

        List<Integer> expected = List.of();

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandGreaterThresholdThanNumbers() {
        List<Integer> nums = List.of(-2, 0, 43, -53, 21, 2, 0, 21, 43);

        List<Integer> actual = FirstTask.getNumsAboveThreshold(nums, 100);

        List<Integer> expected = List.of();

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandLowerThresholdThanNumbers() {
        List<Integer> nums = List.of(-2, 0, 43, -53, 21, 2, 0, 21, 43);

        List<Integer> actual = FirstTask.getNumsAboveThreshold(nums, -500);

        assertEquals(nums, actual);
    }
}

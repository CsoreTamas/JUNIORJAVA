package second;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondTaskTest {
    @Test
    void shouldMergedAlternately() {
        List<Integer> list1 = List.of(1, 3, 5, 7, 9);
        List<Integer> list2 = List.of(2, 4, 6, 8, 10);

        List<Integer> actual = SecondTask.mergeLists(list1, list2);

        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandleDifferentLengths() {
        List<Integer> list1 = List.of(1, 3, 5);
        List<Integer> list2 = List.of(2, 4, 6, 7, 8, 9, 10);

        List<Integer> actual = SecondTask.mergeLists(list1, list2);

        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assertEquals(expected, actual);
    }

    @Test
    void shouldHandEmptyList() {
        List<Integer> list1 = List.of();
        List<Integer> list2 = List.of(1, 2, 3, 4);

        List<Integer> actual = SecondTask.mergeLists(list1, list2);

        List<Integer> expected = List.of(1, 2, 3, 4);

        assertEquals(expected, actual);
    }

    @Test
    void shouldTheListsContainingNegativeNumbers() {
        List<Integer> list1 = List.of(-1, -3, -5);
        List<Integer> list2 = List.of(-2, -4, -6, -7, -8, -9, 10);

        List<Integer> actual = SecondTask.mergeLists(list1, list2);

        List<Integer> expected = List.of(-1, -2, -3, -4, -5, -6, -7, -8, -9, 10);

        assertEquals(expected, actual);
    }

    @Test
    void shouldTheListsContainingDuplicateNumbers() {
        List<Integer> list1 = List.of(1, 1, 1, 1, 1);
        List<Integer> list2 = List.of(2, 2, 2, 2, 2);

        List<Integer> actual = SecondTask.mergeLists(list1, list2);

        List<Integer> expected = List.of(1, 2, 1, 2, 1, 2, 1, 2, 1, 2);

        assertEquals(expected, actual);
    }


}

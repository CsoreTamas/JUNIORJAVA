package firsttest;

import first.First;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {
    @Test
    void shouldRemoveAllDuplicates() {
        List<Integer> actual = List.of(1, 2, 3, 2, 4, 1);
        List<Integer> resouldList = First.removeDuplicates(actual);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertEquals(expected, resouldList);
    }

    @Test
    void shouldHandleMinusNumbers() {
        List<Integer> actual = List.of(-6, 1, 2, 3, 2, -2, 4, 1, -6);
        List<Integer> resouldList = First.removeDuplicates(actual);
        List<Integer> expected = List.of(-6, 1, 2, 3, -2, 4);
        assertEquals(expected, resouldList);
    }

    @Test
    void shouldHandleUniqueValues() {
        List<Integer> actual = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> resouldList = First.removeDuplicates(actual);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        assertEquals(expected, resouldList);
    }

    @Test
    void shouldHandleAllIdenticalValues() {
        List<Integer> actual = List.of(0, 0, 0, 0, 0);
        List<Integer> resouldList = First.removeDuplicates(actual);
        List<Integer> expected = List.of(0);
        assertEquals(expected, resouldList);
    }
}

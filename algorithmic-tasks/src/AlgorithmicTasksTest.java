import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmicTasksTest {
    //15
    @Test
    void shouldGetSmallestSubstring() {
        String text = "aabcbcdbca";
        String text1 = "bvkbdkavbvkaakv";

        String result = AlgorithmicTasks.getSmallestSubstring(text);
        String result1 = AlgorithmicTasks.getSmallestSubstring(text1);

        assertEquals("dbca", result);
        assertEquals("bdkav", result1);
    }

    //16
    @Test
    void shouldGetFirstUniqueChar() {
        String text = "aabbcdeff";

        assertEquals('c', AlgorithmicTasks.getFirstUniqueChar(text));
    }

    //17
    @Test
    void shouldGetAnagramsGroup() {
        List<String> testList = List.of("act", "cat", "dog", "god", "tac");
        Set<String> cat = Set.of("act", "cat", "tac");
        Set<String> dog = Set.of("god", "dog");
        List<Set<String>> expected = List.of(cat, dog);

        assertEquals(expected, AlgorithmicTasks.getAnagramsGroups(testList));
    }


    //18
    @Test
    void shouldGetTheMostFrequentWord() {
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        assertEquals("apple", AlgorithmicTasks.getMostFrequentWord(words));
    }

    //19
    @Test
    void shouldGetDuplicateNumbers() {
        int[] array = {1, 2, 3, 2, 4, 1, 5};
        List<Integer> resultList = List.of(1, 2);
        assertEquals(resultList, AlgorithmicTasks.getDuplicateNumbers(array));
    }

    //20
    @Test
    void shouldReturnTrueDuplicates() {
        int[] first = {1, 2, 2, 3};
        int[] second = {2, 1, 3, 2};
        assertTrue(AlgorithmicTasks.searchDuplicates(first, second));
    }

    @Test
    void shouldReturnFalseNoDuplicates() {
        int[] first = {1, 2, 2, 3};
        int[] second = {4, 5, 6};
        assertFalse(AlgorithmicTasks.searchDuplicates(first, second));
    }

    //21.
    @Test
    void shouldCountMinNumberChanges() {
        String text = "aabbc";
        assertEquals(3, AlgorithmicTasks.countMinNumbersChanges(text));
    }

    //22
    @Test
    void shouldCollectUniqueElement() {
        int[] array = {1, 2, 2, 3, 4, 4, 5};
        List<Integer> expected = List.of(1, 3, 5);
        assertEquals(expected, AlgorithmicTasks.collectUniqueElement(array));
    }

    //23
    @Test
    void shouldGetNumbersFrequency() {
        int[] array = {1, 2, 2, 3, 3, 3};
        Map<Integer, List<Integer>> expectedMap = new HashMap<>();
        expectedMap.put(1, List.of(1));
        expectedMap.put(2, List.of(2));
        expectedMap.put(3, List.of(3));

        assertEquals(expectedMap, AlgorithmicTasks.getNumbersFrequency(array));
    }

    //24
    @Test
    void shouldFlipMaps() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("a", 1);
        testMap.put("b", 2);
        testMap.put("c", 1);

        Map<Integer, List<String>> expectedMap = new HashMap<>();
        expectedMap.put(1, List.of("a", "c"));
        expectedMap.put(2, List.of("b"));
        assertEquals(expectedMap, AlgorithmicTasks.flipMaps(testMap));
    }
}

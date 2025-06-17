import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;


public class RecamansSequenceTest {
    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "2,3", "3,6", "4,2", "5,7", "6,13", "7,20", "8,12", "9,21"})
    void shouldGetTheNthNumbersOfTheRecamansSequence(int index, int expectedNumber) {
        List<Integer> result = RecamansSequence.calculateRecamansSequence(index + 1);
        Assertions.assertEquals(expectedNumber, result.get(index));
    }
}
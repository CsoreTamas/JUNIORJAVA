import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FastPrimeListerTest {
    @Test
    void shouldListPrimes() {
        List<Integer> expected = List.of(2, 3, 5, 7, 11, 13, 17, 19);
        PrimeLister fastPrimeLister = new FastPrimeLister();
        assertEquals(expected, fastPrimeLister.generatePrimes(20));
    }
}

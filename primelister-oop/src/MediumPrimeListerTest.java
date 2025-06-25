import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MediumPrimeListerTest {
    @Test
    void shouldListPrimes() {
        List<Integer> expected = List.of(2, 3, 5, 7, 11, 13, 17, 19);
        PrimeLister mediumPrimeLister = new MediumPrimeLister();
        assertEquals(expected, mediumPrimeLister.generatePrimes(20));
    }
}

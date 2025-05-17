import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForthMediumTaskTest {
    @Test
    void shouldCalculateSpecialSum() {
        Assertions.assertEquals(8, ForthMediumTask.calculateSpecialSum(1, 2, 3, 4));
        Assertions.assertEquals(0, ForthMediumTask.calculateSpecialSum(0, 0, 0, 0));
        Assertions.assertEquals(0, ForthMediumTask.calculateSpecialSum());
        Assertions.assertEquals(-4, ForthMediumTask.calculateSpecialSum(-2, -2, -2, -2));
        Assertions.assertEquals(0, ForthMediumTask.calculateSpecialSum(-2, -2, 2, 2));
    }
}

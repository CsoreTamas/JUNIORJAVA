import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdMediumTaskTest {
    @Test
    void shouldCalculateWierdSumPatter() {
        Assertions.assertEquals(-6, ThirdMediumTask.calculateWierdSumPattern(1, 2, 3, 4));
        Assertions.assertEquals(0, ThirdMediumTask.calculateWierdSumPattern(0));
        Assertions.assertEquals(0, ThirdMediumTask.calculateWierdSumPattern());
        Assertions.assertEquals(0, ThirdMediumTask.calculateWierdSumPattern(-2, -2, -2, -2));
        Assertions.assertEquals(-12, ThirdMediumTask.calculateWierdSumPattern(-2, -2, 2, 2));
        Assertions.assertEquals(-6, ThirdMediumTask.calculateWierdSumPattern(-2, -2));
    }
}

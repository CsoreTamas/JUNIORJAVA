import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondMediumTaskTest {
    @Test
    void shouldCalculateTheSumOfElements() {
        Assertions.assertEquals(16, SecondMediumTask.multiplyNumbersWithTheirIndexAndGetTheSum(2, 4, 6));
        Assertions.assertEquals(0, SecondMediumTask.multiplyNumbersWithTheirIndexAndGetTheSum(0));
        Assertions.assertEquals(0, SecondMediumTask.multiplyNumbersWithTheirIndexAndGetTheSum());
        Assertions.assertEquals(0, SecondMediumTask.multiplyNumbersWithTheirIndexAndGetTheSum(0, 0, 0, 0));
        Assertions.assertEquals(-16, SecondMediumTask.multiplyNumbersWithTheirIndexAndGetTheSum(-2, -4, -6));
        Assertions.assertEquals(25, SecondMediumTask.multiplyNumbersWithTheirIndexAndGetTheSum(0, 0, 0, 0, 0, 5));

    }
}

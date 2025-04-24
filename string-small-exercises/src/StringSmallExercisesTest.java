import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSmallExercisesTest {
    @Test
    void shouldCountTheBInTheString() {
        String testString = "BjkshdsaléBdkjshakldasdhasgB";
        Assertions.assertEquals(3, StringSmallExercises.countTheBOccurrenceInString(testString));
    }

    @Test
    void shouldCountTheHelloInAString() {
        String testString = "hellohello";
        Assertions.assertEquals(2, StringSmallExercises.countHelloInAString(testString));
    }
}

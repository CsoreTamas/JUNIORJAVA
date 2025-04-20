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
        String testString = "hafbsaédhellokaáshellofjsodnfhelloméasl";
        Assertions.assertEquals(3, StringSmallExercises.countHelloInAString(testString));
    }
}

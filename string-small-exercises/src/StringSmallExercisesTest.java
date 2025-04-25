import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSmallExercisesTest {
    @Test
    void shouldCountTheBInTheString() {
        String testString = "BjkshdsaléBdkjshakldasdhasgB";
        Assertions.assertEquals(3, StringSmallExercises.countTheBOccurrenceInString(testString));
        Assertions.assertEquals(1, StringSmallExercises.countTheBOccurrenceInString("Basd"));
        Assertions.assertEquals(1, StringSmallExercises.countTheBOccurrenceInString("asdB"));
        Assertions.assertEquals(3, StringSmallExercises.countTheBOccurrenceInString("BBB"));
        Assertions.assertEquals(1, StringSmallExercises.countTheBOccurrenceInString("B"));
        Assertions.assertEquals(0, StringSmallExercises.countTheBOccurrenceInString(""));
        Assertions.assertEquals(0, StringSmallExercises.countTheBOccurrenceInString("b"));
    }

    @Test
    void shouldCountTheHelloInAString() {
        String start = "helloasdasd";
        String end = "asdasdhello";
        String testString = "hellohello";
        String moreHellos = "hsadhellohasdhellosdhellodsa";
        String hello = "hello";
        String smallerThan5 = "asdf";
        String empty = "";

        Assertions.assertEquals(1, StringSmallExercises.countHelloInAString(start));
        Assertions.assertEquals(1, StringSmallExercises.countHelloInAString(end));
        Assertions.assertEquals(2, StringSmallExercises.countHelloInAString(testString));
        Assertions.assertEquals(3, StringSmallExercises.countHelloInAString(moreHellos));
        Assertions.assertEquals(1, StringSmallExercises.countHelloInAString(hello));
        Assertions.assertEquals(0, StringSmallExercises.countHelloInAString(smallerThan5));
        Assertions.assertEquals(0, StringSmallExercises.countHelloInAString(empty));
    }
}

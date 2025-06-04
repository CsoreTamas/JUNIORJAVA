import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircleTest {
    @Test
    void shouldCalculatePerimeter() {
        Circle circle = new Circle(5);
        Assertions.assertEquals(31.4159, circle.getPerimeter(), 0.0001);

        Circle testCircle = new Circle();
        testCircle.setRadius(3);
        Assertions.assertEquals(18.8496, testCircle.getPerimeter(), 0.0001);
    }

    @Test
    void shouldCalculateArea() {
        Circle circle = new Circle(10);
        Assertions.assertEquals(314.1593, circle.getArea(), 0.0001);

        Circle testCircle = new Circle();
        testCircle.setRadius(8);
        Assertions.assertEquals(201.0619, testCircle.getArea(), 0.0001);
    }
}
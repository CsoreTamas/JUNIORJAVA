import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void shouldCalculatePerimeter() {
        Triangle triangle = new Triangle(10, 10, 20, 0);
        Assertions.assertEquals(40, triangle.getPerimeter());

        Triangle testTriangle = new Triangle();
        testTriangle.setBase(5);
        testTriangle.setSide(5);
        testTriangle.setHypotenuse(8);
        Assertions.assertEquals(18, testTriangle.getPerimeter());
    }

    @Test
    void shouldCalculateArea() {
        Triangle triangle = new Triangle(10, 0, 0, 5);
        Assertions.assertEquals(25, triangle.getArea());

        Triangle testTriangle = new Triangle();
        testTriangle.setBase(5);
        testTriangle.setHeight(9);
        Assertions.assertEquals(22.5, testTriangle.getArea());
    }
}
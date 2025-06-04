import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void shouldCalculatePerimeter() {
        Triangle triangle = new Triangle(13, 10, 20);
        Assertions.assertEquals(43, triangle.getPerimeter());

        Triangle testTriangle = new Triangle();
        testTriangle.setA(2);
        testTriangle.setB(3);
        testTriangle.setC(4);
        Assertions.assertEquals(9, testTriangle.getPerimeter());
    }

    @Test
    void shouldCalculateArea() {
        Triangle triangle = new Triangle(13, 10, 20);
        Assertions.assertEquals(56.14, triangle.getArea(), 0.01);

        Triangle testTriangle = new Triangle();
        testTriangle.setC(2);
        testTriangle.setB(3);
        testTriangle.setA(4);
        Assertions.assertEquals(2.90, testTriangle.getArea(), 0.01);
    }

    @Test
    void shouldReturnWithMinus1() {
        Triangle triangle = new Triangle(9, 10, 20);
        Assertions.assertEquals(-1, triangle.getArea());

        Triangle testTriangle = new Triangle();
        testTriangle.setC(0);
        testTriangle.setB(3);
        testTriangle.setA(4);
        Assertions.assertEquals(-1, testTriangle.getArea());
    }
}
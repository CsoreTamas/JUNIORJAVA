import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    void shouldCalculatePerimeter() {
        Rectangle rectangle = new Rectangle(10, 5);
        Assertions.assertEquals(30, rectangle.getPerimeter());

        Rectangle testRectangle = new Rectangle();
        testRectangle.setHeight(8);
        testRectangle.setWidth(4);
        Assertions.assertEquals(24, testRectangle.getPerimeter());
    }

    @Test
    void shouldCalculateArea() {
        Rectangle rectangle = new Rectangle(5, 5);
        Assertions.assertEquals(25, rectangle.getArea());

        Rectangle testRectangle = new Rectangle();
        testRectangle.setHeight(21);
        testRectangle.setWidth(3);
        Assertions.assertEquals(63, testRectangle.getArea());
    }
}

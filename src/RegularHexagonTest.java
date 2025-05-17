import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegularHexagonTest {
    @Test
    void shouldCalculatePerimeter() {
        RegularHexagon hexagon = new RegularHexagon(5);
        Assertions.assertEquals(30, hexagon.getPerimeter());

        RegularHexagon testHexagon = new RegularHexagon();
        testHexagon.setSide(10);
        Assertions.assertEquals(60, testHexagon.getPerimeter());
    }

    @Test
    void shouldCalculateArea() {
        RegularHexagon hexagon = new RegularHexagon(6);
        Assertions.assertEquals(93.5307, hexagon.getArea(), 0.0001);

        RegularHexagon testHexagon = new RegularHexagon();
        testHexagon.setSide(7);
        Assertions.assertEquals(127.3057, testHexagon.getArea(), 0.0001);
    }
}
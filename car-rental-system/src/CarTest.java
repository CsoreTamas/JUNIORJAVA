import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    void shouldCalculateRentingPrice() {
        Car car = new Car("BMW-001", 1_000, Brand.BMW, "M3");
        assertEquals(10_000, car.calculateRentalCost(10));
    }
}

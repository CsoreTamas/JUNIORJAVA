import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RentalSystemTest {
    @Test
    void shouldFindCarByPlateNumber() {
        RentalSystem rentalSystem = new RentalSystem();
        List<Car> cars = new ArrayList<>();
        rentalSystem.setAvailableCars(cars);

        cars.add(new Car("BMW-001", 5_000, Brand.BMW, "M3"));
        cars.add(new Car("BMW-002", 10_000, Brand.BMW, "M4"));
        cars.add(new Car("BMW-003", 15_000, Brand.BMW, "M5"));

        Car expectedCar = rentalSystem.findByPlateNumber("BMW-002");

        Assertions.assertEquals(cars.get(1), expectedCar);
    }
}

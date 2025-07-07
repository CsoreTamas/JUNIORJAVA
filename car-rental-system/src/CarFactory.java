import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static List<Car> createCars() {

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("BMW-001", 5_000, Brand.BMW, "M3"));
        cars.add(new Car("BMW-002", 10_000, Brand.BMW, "M4"));
        cars.add(new Car("BMW-003", 15_000, Brand.BMW, "M5"));

        cars.add(new Car("MRC-001", 8_000, Brand.MERCEDES, "A120"));
        cars.add(new Car("MRC-002", 16_000, Brand.MERCEDES, "C200"));
        cars.add(new Car("MRC-003", 20_000, Brand.MERCEDES, "AMG 63S"));

        cars.add(new Car("TRABI-1", 3_000, Brand.TRABANT, "601"));
        cars.add(new Car("TRABI-2", 7_000, Brand.TRABANT, "601S"));
        cars.add(new Car("TRABI-3", 35_000, Brand.TRABANT, "TUNINGTRABI"));

        return cars;
    }
}

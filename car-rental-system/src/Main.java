import java.util.List;

public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();
        List<Car> carList = CarFactory.createCars();

        rentalSystem.setAvailableCars(carList);

        rentalSystem.displayAvailableCars();

        Car car = rentalSystem.findByPlateNumber("MRC-003");
        System.out.println(car);

        Car car1 = rentalSystem.findByPlateNumber("IDK-666");
        System.out.println(car1);

        car.displayInfo();

        rentalSystem.rentCar(car, 10);

        rentalSystem.addCar(new Car("BMW-004", 15_000, Brand.BMW, "M6"));
    }
}
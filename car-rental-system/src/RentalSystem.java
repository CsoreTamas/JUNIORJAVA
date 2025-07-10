import java.util.List;
import java.util.Objects;

public class RentalSystem {
    private List<Car> availableCars;

    void addCar(Car car) {
        availableCars.add(car);
        System.out.println("You have successfully added a new car!: " + car);
    }

    public void setAvailableCars(List<Car> availableCars) {
        this.availableCars = availableCars;
    }

    void displayAvailableCars() {
        for (Car car : availableCars) {
            System.out.println(car);
            System.out.println("---------------------------------------------------------------------------");
        }
    }

    Car findByPlateNumber(String plateNumber) {
        for (Car car : availableCars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                System.out.println("Found car: ");
                return car;
            }
        }
        System.out.println("No car whit this plate number: " + plateNumber);
        return null;
    }

    void rentCar(Car car, int days) {
        if (car == null) {
            System.out.println("We don't have car whit this plate number.");
        } else {
            double cost = car.calculateRentalCost(days);
            System.out.printf("%s %s | Plate number: %s | Your cost/day is: %.2f%n" +
                              "Your total cost is gonna be: %.2f Forint%n",
                    car.getBrand(), car.getModel(), car.getPlateNumber(), car.getRentPrice(), cost);
        }
    }
}

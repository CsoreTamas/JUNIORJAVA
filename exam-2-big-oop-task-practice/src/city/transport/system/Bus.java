package city.transport.system;

public class Bus extends PublicTransport {
    public Bus(int capacity, FuelType fuelType) {
        super(capacity, fuelType);
    }

    @Override
    public double calculateFare(double kilometers) {
        return 1.5 + (0.2 * kilometers);
    }

    @Override
    public String toString() {
        return String.format("Type: Bus | Capacity: %d | Eco-friendly: %s | Fare for 5 km: %.2f", getCapacity(), ecoFriendlyLabel(), calculateFare(5));
    }
}

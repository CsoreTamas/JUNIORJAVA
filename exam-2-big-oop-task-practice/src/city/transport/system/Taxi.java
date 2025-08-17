package city.transport.system;

public class Taxi extends PrivateTransport {
    public Taxi(int capacity, FuelType fuelType) {
        super(capacity, fuelType);
    }

    @Override
    public double calculateFare(double kilometers) {
        return 3.0 + (1.1 * kilometers);
    }

    @Override
    public String toString() {
        return String.format("Type: Taxi | Capacity: %d | Eco-friendly: %s | Fare for 5 km: %.2f", getCapacity(), ecoFriendlyLabel(), calculateFare(5));
    }
}

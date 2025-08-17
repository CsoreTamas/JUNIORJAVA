package city.transport.system;

public class Tram extends PublicTransport {
    public Tram(int capacity, FuelType fuelType) {
        super(capacity, fuelType);
    }

    @Override
    public double calculateFare(double kilometers) {
        return 1.0 + (0.15 * kilometers);
    }

    @Override
    public String toString() {
        return String.format("Type: Tram | Capacity: %d | Eco-friendly: %s | Fare for 5 km: %.2f", getCapacity(), ecoFriendlyLabel(), calculateFare(5));
    }
}

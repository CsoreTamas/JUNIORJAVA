package city.transport.system;

public abstract class Transport implements EcoFriendly {
    private final int capacity;
    private final FuelType fuelType;

    public Transport(int capacity, FuelType fuelType) {
        this.capacity = capacity;
        this.fuelType = fuelType;
    }

    public int getCapacity() {
        return capacity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public abstract double calculateFare(double kilometers);

    @Override
    public boolean isEcoFriendly() {
        return fuelType == FuelType.HYBRID || fuelType == FuelType.ELECTRIC;
    }
}

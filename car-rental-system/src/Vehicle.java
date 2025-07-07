public abstract class Vehicle {
    private final String plateNumber;
    private final double rentPrice;


    public Vehicle(String plateNumber, double rentPrice) {
        this.plateNumber = plateNumber;
        this.rentPrice = rentPrice;
    }

    abstract double calculateRentalCost(int days);

    abstract void displayInfo();

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getRentPrice() {
        return rentPrice;
    }
}

public class Car extends Vehicle {
    private Brand brand;
    private String model;


    public Car(String plateNumber, double rentPrice, Brand brand, String model) {
        super(plateNumber, rentPrice);
        this.brand = brand;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    double calculateRentalCost(int days) {
        return days * getRentPrice();
    }

    @Override
    void displayInfo() {
        System.out.printf("This car is a %s %s, Plate number: %s, Renting price is: %.2f%n", brand, model, getPlateNumber(), getRentPrice());
    }

    @Override
    public String toString() {
        return String.format("Brand: %s | Model:%s | Plate number: %s | Rent price: %.2f / day|", brand, model, getPlateNumber(), getRentPrice());
    }
}

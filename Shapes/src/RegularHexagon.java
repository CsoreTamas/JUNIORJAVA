public class RegularHexagon {

    private double side;

    public RegularHexagon() {
        this.side = 3;
    }

    public RegularHexagon(double side) {
        this.side = side;
    }

    public double getArea() {
        return 0.5 * (3 * Math.sqrt(3)) * (2 * side);
    }

    public double getPerimeter() {
        return side * 6;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "RegularHexagon: \n"
               + "  side = " + side + "\n"
               + "  Area = " + getArea() + "\n"
               + "  Perimeter = " + getPerimeter();
    }
}

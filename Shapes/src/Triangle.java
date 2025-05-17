public class Triangle {

    private double base;
    private double side;
    private double hypotenuse;
    private double height;

    public Triangle() {
        this.base = 3;
        this.side = 2;
        this.hypotenuse = 5;
        this.height = 4;
    }

    public Triangle(double base, double side, double hypotenuse, double height) {
        this.base = base;
        this.side = side;
        this.hypotenuse = hypotenuse;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }

    public double getPerimeter() {
        return base + side + hypotenuse;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }

    public void setHypotenuse(double hypotenuse) {
        this.hypotenuse = hypotenuse;
    }

    @Override
    public String toString() {
        return "Triangle: \n"
               + "  base = " + base + "\n"
               + "  side = " + side + "\n"
               + "  height = " + height + "\n"
               + "  hypotenuse = " + hypotenuse + "\n"
               + "  Area = " + getArea() + "\n"
               + "  Perimeter = " + getPerimeter();
    }
}

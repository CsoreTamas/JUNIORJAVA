public class Rectangle {

    private double width;
    private double height;

    public Rectangle() {
        this.width = 5;
        this.height = 3;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle \n"
               + "  Width = " + width + " Height = " + height + "\n"
               + "  Area = " + getArea() + "\n"
               + "  Perimeter = " + getPerimeter();
    }
}

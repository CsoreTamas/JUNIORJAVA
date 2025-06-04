
public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;


    public Triangle() {
        this.a = 3;
        this.b = 2;
        this.c = 5;

    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        if (isValid()) {
            return -1;
        }
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getPerimeter() {
        if (!isValid()) {
            return -1;
        }
        return a + b + c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public boolean isValid() {
        return a + b > c && a + c > b && b + c > a;
    }

    @Override
    public String toString() {
        return "Triangle: \n"
               + "  a = " + a + "\n"
               + "  b = " + b + "\n"
               + "  c = " + c + "\n"
               + "  Area = " + getArea() + "\n"
               + "  Perimeter = " + getPerimeter();
    }
}

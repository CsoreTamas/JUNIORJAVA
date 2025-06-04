public class Shapes {
    public static void main(String[] args) {

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);

        System.out.println(circle1);
        System.out.println(circle2);

        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(8, 8);

        System.out.println(rectangle1);
        System.out.println(rectangle2);

        Triangle triangle1 = new Triangle();
        Triangle triangle2 = new Triangle(10, 5, 7);

        System.out.println(triangle1);
        System.out.println(triangle2);

        RegularHexagon hexagon1 = new RegularHexagon();
        RegularHexagon hexagon2 = new RegularHexagon(5);

        System.out.println(hexagon1);
        System.out.println(hexagon2);
    }
}
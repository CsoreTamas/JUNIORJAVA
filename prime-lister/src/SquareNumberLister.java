import java.util.Scanner;

public class SquareNumberLister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = PrimeLister.getValidNumber(scanner);
        for (int i = 1; i < number; i++) {
            if (isSquareNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isSquareNumber(int number) {
        if (number <= 0) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(number);
        return squareRoot * squareRoot == number;
    }
}

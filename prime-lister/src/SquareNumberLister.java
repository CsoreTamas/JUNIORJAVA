import java.util.Scanner;

public class SquareNumberLister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = PrimeLister.getValidNumber(scanner);
        for (int i = 1; i < number; i++) {
            if (isSquareRoot(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isSquareRoot(int number) {
        if (number <= 0) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(number);
        return squareRoot * squareRoot == number;
    }
}

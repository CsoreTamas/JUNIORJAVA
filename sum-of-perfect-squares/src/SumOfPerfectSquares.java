import java.util.Scanner;

public class SumOfPerfectSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = getANumberFromTheUser(scanner);
        if (isSmallerThanOne(number)) {
            return;
        }
        System.out.println(getNumbersSquaresSum(number));
    }

    public static int getANumberFromTheUser(Scanner scanner) {
        System.out.print("Please enter a number: ");
        return scanner.nextInt();
    }

    public static boolean isSmallerThanOne(int number) {
        if (number < 1) {
            System.err.println("The number should be greater than 1!");
            return true;
        }
        return false;
    }

    public static int getNumbersSquaresSum(int number) {
        int squares = 0;
        for (int i = 1; i <= number; i++) {
            squares += (int) Math.pow(i, 2);
        }
        return squares;
    }
}
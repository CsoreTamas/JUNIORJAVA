import java.util.Scanner;

public class StrangePolynomialSumMedium {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int number = scanner.nextInt();

        if (number < 1) {
            System.exit(0);
        }
        int result = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 4 == 2) {
                result += (int) Math.pow(i, 2);
            } else if (i % 4 == 3) {
                result += (int) Math.pow(i, 3);
            } else if (i % 4 == 0) {
                result += (int) Math.pow(i, 4);
            } else {
                result += i;
            }
        }
        System.out.println(result);

        scanner.close();
    }
}
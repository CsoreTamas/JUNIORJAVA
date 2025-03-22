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
            result += calculateTerm(i);
        }
        System.out.println(result);

        scanner.close();
    }

    public static int calculateTerm(int number) {
        int result = 0;
        switch (number % 4) {
            case 1:
                result += number;
                break;
            case 2:
                result += (int) Math.pow(number, 2);
                break;
            case 3:
                result += (int) Math.pow(number, 3);
                break;
            case 0:
                result += (int) Math.pow(number, 4);
                break;
        }
        return result;
    }
}
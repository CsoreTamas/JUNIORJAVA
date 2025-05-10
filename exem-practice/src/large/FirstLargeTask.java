//Ask the user for a number between 20 and 1,000,000. Keep asking the user for
// the number while the value is invalid. Generate the list of factorial values
// less than the number, and return the sum of every second factorial. Include
// tests for input and factorial logic. Test all your methods properly.

import java.util.ArrayList;
import java.util.Scanner;

public class FirstLargeTask {
    public static void main(String[] args) {

        int number = getValidInput();
        ArrayList<Integer> factorials = calculateFactorialsUntilNumber(number);
        int sum = calculateTheSumOfEveryTwoFactorials(factorials);
        System.out.println(sum);
    }

    public static int getValidInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int number = scanner.nextInt();

        while (!isValid(number)) {
            System.out.print("Please enter a number between 20 and 1000000: ");
            number = scanner.nextInt();
        }
        return number;
    }

    public static boolean isValid(int num) {
        return num >= 20 && num <= 1000000;
    }

    public static ArrayList<Integer> calculateFactorialsUntilNumber(int number) {
        ArrayList<Integer> factorials = new ArrayList<>();
        int factorial = 1;
        for (int i = 1; factorial < number; i++) {
            factorials.add(factorial);
            factorial *= (i + 1);
        }
        return factorials;
    }

    public static int calculateTheSumOfEveryTwoFactorials(ArrayList<Integer> factorials) {
        int sum = 0;
        for (int i = 0; i < factorials.size(); i += 2) {
            sum += factorials.get(i);
        }
        return sum;
    }
}

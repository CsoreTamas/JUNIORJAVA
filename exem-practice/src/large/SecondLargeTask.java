//Ask the user to enter a number between 50 and 10000. Generate all perfect squares less than that number
// and return the sum of every 5th one. Include unit tests for input validation and square generation.

import java.util.ArrayList;
import java.util.Scanner;

public class SecondLargeTask {
    public static void main(String[] args) {
        int number = getValidInput();
        ArrayList<Integer> squares = calculatePerfectSquaresUntilNumber(number);
        int sum = summingEvery5thElement(squares);
        System.out.println(sum);
    }

    public static int getValidInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        while (!isValid(number)) {
            System.out.print("Enter a valid number between 50 and 10000: ");
            number = scanner.nextInt();
        }
        return number;
    }

    public static boolean isValid(int number) {
        return number >= 50 && number <= 10_000;
    }

    public static ArrayList<Integer> calculatePerfectSquaresUntilNumber(int number) {
        ArrayList<Integer> squaresList = new ArrayList<>();
        for (int i = 1; i * i < number; i++) {
            squaresList.add(i * i);
        }
        return squaresList;
    }

    public static int summingEvery5thElement(ArrayList<Integer> squaresList) {
        int sum = 0;
        for (int i = 4; i < squaresList.size(); i += 5) {
            sum += squaresList.get(i);
        }
        return sum;
    }
}

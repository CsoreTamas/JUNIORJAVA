import java.util.Scanner;

public class FifthTask {
    public static void main(String[] args) {
        int number = getValidUserInput();
        double reciprocalSumTillNumber = calculateReciprocalSumOfSquaresTillNumber(number);
        double sumOfReciprocalSum = calculateReciprocalSumTendingInfinity() - reciprocalSumTillNumber;
        System.out.println(sumOfReciprocalSum);
        System.out.println(calculateReciprocalSumTendingInfinity() + "   1212");
        if (number == 5) {
            System.out.println("You found an Easter egg!");
        } else if (number == 15000) {
            System.out.println("You find an Easter egg!");
        }
        divisibleBy2000(number);
    }

    public static int getValidUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!");
        System.out.print("Please enter a number: ");
        int number = scanner.nextInt();

        for (int counter = 0; counter < 10; number = scanner.nextInt()) {
            if (isValid(number)) {
                return number;
            }
            counter++;
            if (counter <= 2) {
                System.out.print("Please enter a number again: ");
            } else if (counter <= 6) {
                System.out.print("Please enter a number between 5-15000: ");
            } else {
                System.out.print("Please enter a number between 5-15000 (for example 10,634,1235): ");
            }
        }
        System.out.print("You couldn't enter a valid number!");
        System.out.print("Good bye!");
        System.exit(0);
        return -1;
    }

    public static boolean isValid(int number) {
        return number >= 5 && number <= 15000;
    }

    public static double calculateReciprocalSumOfSquaresTillNumber(int number) {
        double sum = 0;
        for (int i = 1; i <= number; i++) {
            double sqrtI = Math.sqrt(i);
            if (sqrtI * sqrtI == i) {
                sum += (double) 1 / (i * i);
            }
        }
        return sum;
    }

    public static double calculateReciprocalSumTendingInfinity() {
        return Math.PI * Math.PI / 6;
    }

    public static void divisibleBy2000(int number) {
        System.out.println("Thanks for being here good bye!");

        int start = (number / 2000) * 2000;
        if (start > 0) {
            for (int i = start; i > 0; i -= 2000) {
                System.out.println(i);
            }
        }
    }
}

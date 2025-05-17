import java.util.Scanner;

public class PrimeLister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = getValidNumber(scanner);
        for (int i = 1; i < number; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isValidNumber(int number) {
        return number <= 2_000_000_000 && number >= 2;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int getValidNumber(Scanner scanner) {
        int failCounter = 0;
        int number;
        while (failCounter <= 5) {
            System.out.print("Please enter a number: ");
            number = scanner.nextInt();
            if (!isValidNumber(number)) {
                failCounter++;
                System.out.println("Please enter a number between 2 - 2_000_000_000: ");
            } else {
                return number;
            }
        }
        return -1;
    }

}
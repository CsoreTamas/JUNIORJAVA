import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TribonacciNumbers {
    public static void main(String[] args) {
        boolean runAgain = true;

        do {
            int number = getValidNumber();
            if (number == 12) {
                int[] array = ifThenUmber12();
                List<Integer> fibonacciNumbers = calculateFibonacci(array);
                System.out.println(fibonacciNumbers);
            } else if (number == 16) {
                List<Integer> divisors = ifTheNumber16();
                System.out.println(divisors);
            } else {
                List<Integer> tribonacciNumbers = calculateTribonacci(number);
                System.out.println(tribonacciNumbers);
            }

            System.out.println("Are you wan to run the program once again?");
            System.out.println("Please enter Yes or No!");
            Scanner scanner = new Scanner(System.in);
            String decide = scanner.next();
            if (decide.equalsIgnoreCase("no")) {
                runAgain = false;
                System.out.println("Thanks for being here! Goodbye");
            }
        } while (runAgain);

    }

    public static int getValidNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!!");
        System.out.print("Please enter a number. : ");
        int number = scanner.nextInt();

        for (int counter = 0; counter < 7; number = scanner.nextInt()) {
            if (isValid(number)) {
                return number;
            }

            ++counter;
            if (counter <= 4) {
                System.out.print("Please enter a number agarin. :");
            } else {
                System.out.print("Please enter a number between 4-25! : ");
            }
        }

        System.out.println("You couldn't enter a valid number! GoodBye!");
        System.exit(0);
        return -1;
    }

    public static boolean isValid(int number) {
        return number >= 4 && number <= 25;
    }

    public static List<Integer> calculateTribonacci(int number) {
        List<Integer> tribonacciList = new ArrayList<>(Arrays.asList(0, 1, 2));

        for (int i = 3; i < number; ++i) {
            int tribonacciNumbers = (Integer) tribonacciList.get(i - 1) + (Integer) tribonacciList.get(i - 2) + (Integer) tribonacciList.get(i - 3);
            tribonacciList.add(tribonacciNumbers);
        }

        return tribonacciList;
    }

    public static int[] ifThenUmber12() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You find an Easter Egg!! Please enter 2 number!");
        System.out.print("First number: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Second number: ");
        int secondNumber = scanner.nextInt();
        return new int[]{firstNumber, secondNumber};
    }

    public static List<Integer> calculateFibonacci(int[] array) {
        List<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(array[0]);
        fibonacciList.add(array[1]);

        for (int i = 2; i < 12; ++i) {
            int fibonacciNumber = fibonacciList.get(i - 1) + fibonacciList.get(i - 2);
            fibonacciList.add(fibonacciNumber);
        }

        return fibonacciList;
    }

    public static List<Integer> ifTheNumber16() {
        System.out.println("You find an Easter Egg in this program!");
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= 16; ++i) {
            if (16 % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }
}


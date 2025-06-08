import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        int number = getValidInput();
        System.out.println("Your number is: " + number);
        if (number == 4993) {
            System.out.println("BINGO");
        }

        List<Integer> divisors = getDivisors(number);
        System.out.println("The divisors of " + number + " in descending order: " + String.valueOf(divisors));
        if (!isPrime(number)) {
            getClosestPrime(number);
        }

        calculateIceCreamPrice(number);
        calculateVolumeOfCube(number);
        isPerfectCube(number);
        changeToEur(number);
    }

    public static int getValidInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!");
        System.out.print("Please enter a number: ");
        int number = scanner.nextInt();

        for (int counter = 0; counter < 5; number = scanner.nextInt()) {
            if (isValid(number)) {
                return number;
            }

            ++counter;
            if (counter <= 3) {
                System.out.print("Please try to enter a valid number: ");
            } else {
                System.out.println("Valid numbers are between 1-5000.");
                System.out.print("Try again.");
            }
        }

        System.out.println("You couldn't enter a valid number! Goodbye!");
        System.exit(0);
        return -1;
    }

    public static boolean isValid(int number) {
        return number >= 1 && number <= 5000;
    }

    public static List<Integer> getDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = number; i >= 1; --i) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for (double i = 2; i <= Math.sqrt(number); ++i) {
                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static int getClosestPrime(int number) {
        for (int i = number; i <= number + 1000; ++i) {
            if (isPrime(i)) {
                System.out.println("Closest prime to your number is : " + i);
                return i;
            }
        }

        return -1;
    }

    public static int calculateIceCreamPrice(int number) {
        int iceCream = number * 275;
        System.out.println(number + " ice cream value is " + iceCream + " Forint");
        return iceCream;
    }

    public static long calculateVolumeOfCube(int number) {
        long volume = (long) number * (long) number * (long) number;
        System.out.println("Volume of your cube: " + volume + " m^3.");
        return volume;
    }

    public static boolean isPerfectCube(int number) {
        if (Math.cbrt((double) number) % (double) 1.0F != (double) 0.0F) {
            System.out.println("Your number is not a cube number!");
        } else {
            System.out.println("Your number is a perfect cube!");
        }

        return false;
    }

    public static double changeToEur(int number) {
        double eur = (double) number / (double) 340.0F;
        System.out.println("You can get " + eur + " Euro.");
        return eur;
    }
}

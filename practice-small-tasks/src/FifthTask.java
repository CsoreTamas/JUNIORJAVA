import java.util.Scanner;

public class FifthTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number >= 2) {
            calculatePrimeDivisor(number);

            int maxDivisor = getMaxDivisor(number);

            getNextPrimeAboveMaxDivisor(maxDivisor, number);
            getClosestPrimeUnderMaxDivisor(maxDivisor);
        }
    }

    private static void getClosestPrimeUnderMaxDivisor(int maxDivisor) {
        for (int i = maxDivisor; i > 0; i--) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static void getNextPrimeAboveMaxDivisor(int maxDivisor, int number) {
        for (int i = maxDivisor; i <= number * 2; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static int getMaxDivisor(int number) {
        int maxDivisor = 1;

        for (int i = 1; i < number; ++i) {
            if (number % i == 0) {
                maxDivisor = i;
            }
        }
        return maxDivisor;
    }

    private static void calculatePrimeDivisor(int number) {
        int primeDivisor = 0;

        for (int i = 2; i < number; ++i) {
            if (number % i == 0 && isPrime(i)) {
                primeDivisor = i;
            }
        }

        if (primeDivisor != 0) {
            System.out.println(primeDivisor);
        } else {
            System.out.println("There is no prime divisor.");
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 2; (double) i <= Math.sqrt((double) number); ++i) {
                if (number % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
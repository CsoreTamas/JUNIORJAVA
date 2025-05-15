public class ForthTask {
    public static void main(String[] args) {
        for (int i = 15003; i < 1416221; ++i) {
            if (i % 5 == 0 && !isEndWith0(i) && !isDivisibleBy3(i) && positiveDivisor(i) && greaterThan8Factorial(i)) {
                System.out.println(i);
            }
        }

    }

    public static boolean isEndWith0(int number) {
        return number % 10 == 0;
    }

    public static boolean isDivisibleBy3(int number) {
        return number % 3 == 0;
    }

    public static boolean positiveDivisor(int number) {
        int counter = 0;

        for (int i = 1; i < number; ++i) {
            if (number % i == 0) {
                ++counter;
            }
        }

        return counter <= 12;
    }

    public static boolean greaterThan8Factorial(int number) {
        int eightFactorial = 1;

        for (int i = 1; i <= 8; ++i) {
            eightFactorial *= i;
        }

        return number > eightFactorial;
    }
}

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number >= 2 && number <= 100000) {
            int maxDivisor = 0;
            int numberWithMaxDivisor = 1;

            for (int i = 0; i < number; ++i) {
                int divisorsCount = countDivisors(i);
                if (maxDivisor < divisorsCount) {
                    maxDivisor = divisorsCount;
                    numberWithMaxDivisor = i;
                }
            }

            System.out.println(numberWithMaxDivisor);
        }
    }

    public static int countDivisors(int number) {
        int counter = 0;

        for (int i = 1; i < number; ++i) {
            if (number % i == 0) {
                ++counter;
            }
        }
        return counter;
    }
}
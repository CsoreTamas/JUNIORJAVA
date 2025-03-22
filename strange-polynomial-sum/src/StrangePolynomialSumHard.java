import java.util.Scanner;

public class StrangePolynomialSumHard {
    public static void main(String[] args) {
        int number = getANumber();
        System.out.println(calculateTheNumberResult(number));
    }

    public static int getANumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        return scanner.nextInt();
    }


    public static int calculateTheNumberResult(int number) {
        if (number < 1) {
            System.exit(0);
        }

        int result = 0;
        for (int i = 1; i <= number; i++) {
            int partNumber = 0;
            if (i % 3 == 2) {
                partNumber += i * i;
            } else if (i % 3 == 0) {
                partNumber += i * i * i;
            } else if (i % 3 == 1 && i % 6 != 1) {
                result -= i;
            } else if (i % 6 == 1) {
                result += i;
            }
            if (i % 5 == 0) {
                partNumber *= 2;
            }
            if (i % 2 == 0) {
                result -= partNumber;
            } else {
                result += partNumber;
            }
            if (i % 30 == 10) {
                result -= i;
            } else if (i % 30 == 25) {
                result += i;
            }
        }
        result *= number;
        return result;
    }
}

// The number can never be a prim number because it's always going to be negative number.

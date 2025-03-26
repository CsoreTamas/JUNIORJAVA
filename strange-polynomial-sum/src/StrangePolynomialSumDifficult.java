import java.util.Scanner;

public class StrangePolynomialSumDifficult {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = getANumber(scanner);
        if (isSmallerThanOne(number)) {
            return;
        }
        int result = 0;
        for (int i = 1; i <= number; i++) {
            int partNumber = 0;
            partNumber = calculatePartNumber(i, partNumber);
            result = calculateSum(i, result);
            partNumber = handleMultipleOfFive(i, partNumber);
            result = isDivisibleByTwo(i, result, partNumber);
            result = isDivisibleByThirty(i, result);
        }
        result = calculateFinalResult(result, number);
        System.out.println(result);
    }

    public static int getANumber(Scanner scanner) {
        System.out.print("Please enter a number: ");
        return scanner.nextInt();
    }

    public static boolean isSmallerThanOne(int number) {
        return number < 1;
    }

    public static int calculatePartNumber(int i, int partNumber) {
        if (i % 3 == 2) {
            partNumber += i * i;
        } else if (i % 3 == 0) {
            partNumber += i * i * i;
        }
        return partNumber;
    }

    public static int calculateSum(int i, int result) {
        if (i % 3 == 1 && i % 6 != 1) {
            result -= i;
        } else if (i % 6 == 1) {
            result += i;
        }
        return result;
    }

    public static int handleMultipleOfFive(int i, int partNumber) {
        if (i % 5 == 0) {
            partNumber *= 2;
        }
        return partNumber;
    }

    public static int isDivisibleByTwo(int i, int result, int partNumber) {
        if (i % 2 == 0) {
            result -= partNumber;
        } else {
            result += partNumber;
        }
        return result;
    }

    public static int isDivisibleByThirty(int i, int result) {
        if (i % 30 == 10) {
            result -= i;
        } else if (i % 30 == 25) {
            result += i;
        }
        return result;
    }

    public static int calculateFinalResult(int result, int number) {
        return result * number;
    }
}




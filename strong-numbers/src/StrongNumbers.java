import java.util.Scanner;

public class StrongNumbers {
    public static void main(String[] args) {
        System.out.println(decideTrueOrNot(145));
    }

    //O(9)
    public static int factorial(int number) {
        int partNumber = 1;
        for (int i = 1; i <= number; i++) {
            partNumber *= i;
        }
        return partNumber;
    }

    //O(1)
    public static int calculateFinalAddition(int partNumber, int result) {
        return result + partNumber;

    }

    //O(1)
    public static boolean decideTrueOrNot(int number) {
        //Convert int to String
        String stringNumber = Integer.toString(number);

        int result = 0;
        int partNumber = 0;
        for (int i = 0; i < stringNumber.length(); i++) {
            //Get the i-th element
            char index = stringNumber.charAt(i);
            //Character.getNumericValue() ---> Char to Numeric value!!
            int numericValue = Character.getNumericValue(index);
            partNumber = factorial(numericValue);
            result = calculateFinalAddition(partNumber, result);
        }
        return result == number;
    }
}

// Could be O(n+9) ? --> O(n)
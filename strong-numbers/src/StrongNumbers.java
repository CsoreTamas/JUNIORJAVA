import java.util.Scanner;

public class StrongNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = getANumberFromTheUser(scanner);

        //Convert int to String
        String stringNumber = Integer.toString(number);

        int result = 0;
        int partNumber;
        //O(n)
        for (int i = 0; i < stringNumber.length(); i++) {
            //Get the i-th element
            char index = stringNumber.charAt(i);

            //Character.getNumericValue() ---> Char to Numeric value!!
            partNumber = Character.getNumericValue(index);

            //With the implemented method, we calculate the numeric value of the i-th character!
            result = calculateFinalAddition(result, factorial(partNumber));
        }
        System.out.println(decideTrueOrNot(number, result));

    }

    //O(1)
    public static int getANumberFromTheUser(Scanner scanner) {
        System.out.print("Please enter a number! : ");
        return scanner.nextInt();
    }

    //O(n)
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
    public static boolean decideTrueOrNot(int result, int number) {
        return result == number;
    }
}

// Could be O(n^2) ? 
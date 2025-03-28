import java.util.Scanner;

public class StrongNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = getANumberFromTheUser(scanner);

        //Convert int to String
        String stringNumber = Integer.toString(number);

        int result = 0;
        int partNumber;
        for (int i = 0; i < stringNumber.length(); i++) {
            //Get the i-th element
            char index = stringNumber.charAt(i);

            //Character.getNumericValue() ---> Char to Numeric value!!
            partNumber = Character.getNumericValue(index);

            //With the implemented method, we calculate the numeric value of the i-th character!
            result = calculateFinalAddition(result, calculateFactorials(partNumber));
        }
        System.out.println(result);
    }

    public static int getANumberFromTheUser(Scanner scanner) {
        System.out.print("Please enter a number! : ");
        return scanner.nextInt();
    }

    public static int calculateFactorials(int number) {
        int partNumber = 1;
        for (int i = 1; i <= number; i++) {
            partNumber *= i;
        }
        return partNumber;
    }

    public static int calculateFinalAddition(int partNumber, int result) {
        return result + partNumber;
    }
}
//One question. Do I calculate the time complexity by determining the time requirement of each part and then combining them?
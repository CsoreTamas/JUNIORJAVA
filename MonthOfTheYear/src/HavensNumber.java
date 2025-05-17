import java.util.Scanner;

public class HavensNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 100 && number % 2 == 0 && number % 7 != 0) {
            System.out.println("Havenly number.");
        } else if (number > 300 && number % 13 == 0) {

        }
    }
}

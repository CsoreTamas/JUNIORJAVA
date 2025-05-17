import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();


        if (number < 5) {
            System.out.println("Your number is not bigger than 5!");

        } else if (5 == number) {
            System.out.println("Your number is equals 5");
        } else {
            System.out.println("Your number is bigger than 5");
        }

    }
}
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number;

        do {
            System.out.print("Please enter a number: ");
            number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Please enter a number greater than 0 ");
            }
        } while (number < 0);

        for (int i = 1; i < number + 1; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else System.out.println(i);
        }


    }
}


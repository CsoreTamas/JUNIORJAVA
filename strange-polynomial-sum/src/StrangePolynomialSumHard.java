import java.util.Scanner;

public class StrangePolynomialSumHard {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int number = scanner.nextInt();

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
            } else if (i % 3 == 1 && i % 6 != 1) {  //i != 1 && i != 7 && i != 13) {
                result -= i;
            } else if (i % 6 == 1) {  //(i == 1 || i == 7 || i == 13) {
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
            if (i % 30 == 10) {  //(i == 10 || i == 40 || i == 70 || i == 100) {
                result -= i;
            } else if (i % 30 == 25) {  //(i == 25 || i == 55 || i == 85 || i == 115) {
                result += i;
            }
            // +5^2 /    ||-10^1 ||   / +15^3 / -20^2 /    ||+25^1 ||   / -30^3
            // +35^2/    ||-40^1 ||   / +45^3 / -50^2 /    ||+55^1 ||   / -60^3
            // +65^2/    ||-70^1 ||   / +75^3 / -80^2 /    ||+85^1 ||   / -90^3
            // +95^2/    ||-100^1||   / +105^3/ -110^2/    ||+115^1||
        }
        result *= number;
        System.out.println(result);

        scanner.close();
    }
}

// The number can never be a prim number because it's always going to be negative number.

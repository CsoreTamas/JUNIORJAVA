import java.util.Scanner;

public class StrangePolynomialSumMedium {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number: ");
        int number = scanner.nextInt();

        if (StrangePolynomialSumDifficult.isSmallerThanOne(number)) {
            System.err.println("You should enter a number which greater than 1!");
            System.exit(0);
        }
        int result = 0;
        System.out.println(result += calculateTerm((number)));

        scanner.close();
    }

    public static int calculateTerm(int number) {
        int remainder = number % 4;
        return (int) Math.pow(number, remainder == 0 ? 4 : remainder);

    }
}
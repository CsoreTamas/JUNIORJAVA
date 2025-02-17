import java.util.Scanner;

public class FirstLoopHomework {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a text: ");
        String text = scanner.nextLine();
        System.out.print("Please enter a number: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.err.println("Wrong number.");
        }
        for (int i = 0; i < number; i++) {
            {
                System.out.println(text);
            }

            scanner.close();
        }
    }
}

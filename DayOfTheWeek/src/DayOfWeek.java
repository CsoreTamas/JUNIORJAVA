import java.util.Scanner;


public class DayOfWeek {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number between 1-7: ");
        int dayOfWeek = scanner.nextInt();

        if (dayOfWeek == 1) {
            System.out.println("1 → Monday");
        } else if (dayOfWeek == 2) {
            System.out.println("2 → Tuesday");
        } else if (dayOfWeek == 3) {
            System.out.println("3 → Wednesday");
        } else if (dayOfWeek == 4) {
            System.out.println("4 → Thursday");
        } else if (dayOfWeek == 5) {
            System.out.println("5 → Friday");
        } else if (dayOfWeek == 6) {
            System.out.println("6 → Saturday");
        } else if (dayOfWeek == 7) {
            System.out.println("7 → Sunday");
        } else {
            System.err.print("Error! You should pick a number between 1-7");
        }
        scanner.close();
    }
}
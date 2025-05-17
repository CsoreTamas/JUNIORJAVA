import java.util.Scanner;

public class BusinessCard {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        int age;
        do {
            System.out.print("Please enter your age: ");
            age = scanner.nextInt();
            if (age < 0) {
                System.out.println("The age is in valid!");
                System.out.print("Please enter your age again: ");
                age = scanner.nextInt();
            }
        } while (age < 0);


        String emptyLineTrash = scanner.nextLine();


        System.out.print("Please enter your e-mail: ");
        String eMail = scanner.nextLine();

        System.out.print("Please enter you phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Please enter your social media availability: ");
        String socialMedia = scanner.nextLine();

        System.out.println("Your business card: \n");

        scanner.close();

        int maxLength = Math.max(Math.max(name.length(), String.valueOf(age).length()), Math.max(eMail.length(), phoneNumber.length()));

        String separator = "+-".repeat(maxLength / 2 + 7);

        System.out.println(separator);
        System.out.printf("|Name: %-" + (maxLength) + "s     |\n", name);
        System.out.println(separator);
        System.out.printf("|Age: %-" + (maxLength) + "s      |\n", age);
        System.out.println(separator);
        System.out.printf("|E-mail: %-" + (maxLength) + "s   |\n", eMail);
        System.out.println(separator);
        System.out.printf("|Phone: %-" + (maxLength) + "s    |\n", phoneNumber);
        System.out.println(separator);
        System.out.printf("|LinkedIn: %-" + (maxLength) + "s |\n", socialMedia);
        System.out.println(separator);

    }
}




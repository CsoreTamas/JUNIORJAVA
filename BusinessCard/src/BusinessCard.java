import java.util.Scanner;

public class BusinessCard {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérem adja meg a nevét: ");
        String name = scanner.nextLine();

        int age;
        do {
            System.out.print("Kérem adja meg az életkorát: ");
            age = scanner.nextInt();
            if (age < 0) {
                System.out.println("Az életkor nem megfelelő!");
                System.out.print("Kérem adja meg az életkorát ismét: ");
                age = scanner.nextInt();
            }
        } while (age < 0);


        String emptyLineTrash = scanner.nextLine();


        System.out.print("Kérem adja meg az e-mail címét: ");
        String eMail = scanner.nextLine();

        System.out.print("Kérem adja meg telefonszámát: ");
        String phoneNumber = scanner.nextLine();


        System.out.println("Az ön által megadot adatok szerinti kártyája: \n");

/*
        int emailLength = "E-mail: ".length() + eMail.length();

        int cols = emailLength + 4;
        int rows = 9;

        // String columnNumber = "M".repeat(cols);


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                //Ha a legelső és az utolsó sorban van
                if (i == 0 || i == rows - 1) {
                    System.out.print("x");

                    //Ha az első és utolsó oszlopban van.
                } else if (j == 0 || j == cols - 3) {
                    System.out.print("x");


                } else if (i == 1 && j < name.length() + 7) {
                    if (j == 6) System.out.print(" Név: ");
                    else if (j > 6 && j < name.length() + 7) {
                        System.out.print(name.charAt(j - 7));
                    }


                } else if (i == 3) {      //&& j < String.valueOf(age).length()) {
                    if (j == 6) {
                        System.out.print(" Kor: ");
                    }
                    if (j > 6 && j < 7 + String.valueOf(age).length()) {
                        System.out.print(String.valueOf(age).charAt(j - 7));
                    }


                } else if (i == 5 && j < eMail.length() + 8) {
                    if (j == 5) {
                        System.out.print(" E-mail: ");
                    }
                    if (j > 6 && j < eMail.length() + 7) {
                        System.out.print(eMail.charAt(j - 7));
                    }


                } else if (i == 7) { // && j < phoneNumber.length()) {
                    if (j == 7) {
                        System.out.print(" Telefonszám: ");
                    }
                    if (j > 15 && j < 16 + phoneNumber.length()) {
                        System.out.print(phoneNumber.charAt(j - 16));
                    }

                } else if (i == 2 || i == 4 || i == 6) {
                    System.out.print("x");


                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();

        }
        scanner.close();
*/
        int rows = 9;
        int cols = eMail.length() + 3;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j <= rows; j++) {
                if (0 < i || i == cols) {
                    System.out.print("M");
                } else if (i < cols || i == 9) {
                    System.out.println("x");
                } else {
                    System.out.println();

                }
            }
        }
    }
}


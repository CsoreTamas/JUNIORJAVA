import java.util.Scanner;

public class LoopBasicTasksTwo {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println("Hello world! ");
        }

        int multipleOfFive = 0;
        for (int i = 0; i < 20; i++) {
            multipleOfFive += 5;
            System.out.println(multipleOfFive);
        }

        float multipleOf038 = 0F;
        for (int i = 0; i < 3057; i++) {
            multipleOf038 += 0.38F;
            System.out.printf("%.3f%n", multipleOf038); // printf("%.3f%n") azt jelenti hogy 0.123 ig írja ki a számokat!!
        }                                               // ha pl printf("%.2f%n") lenne akkor viszont 0.12 ig írja ki!!

        for (int i = 100; 1 <= i; i--) {
            System.out.println(i);
        }


        for (int numberToCheck = 2; numberToCheck <= 100; numberToCheck++) {
            // for ciklus arra, hogy 2-100 ig elleőrizze a számokat
            boolean isPrime = true;
            // azt állítjuk minden számról, hogy prím
            for (int divisorNumber = 2; divisorNumber <= Math.sqrt(numberToCheck); divisorNumber++) {
                // a forciklus azért, hogy leelenőrizzük, hogy prím-e vagy nem akkora számig megyün kel az
                // ellenörzésnél amekkora az ellenőrzendő szám négyzetgyöke. (16-nál 4 ig)
                if (numberToCheck % divisorNumber == 0) {
                    //Ha az az szám amit ellenzörzünk osztahtó azzal a számmal amivel ellenőzizzük (pl 16:2)
                    // és a maradéka 0 akkor HAMIS azaz nem prím!!!
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(numberToCheck);
            }
        }

        for (int i = -50; i <= 50; i++) {
            System.out.println(i);
        }

        for (int i = 1; i < 200; i++) {
            if (i % 7 == 0) {
                System.out.println(i);
            }
        }

        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                System.out.println(i);
            }
        }

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);

        int prod = 1;
        for (int i = 1; i <= 10; i++) {
            prod *= i;
        }
        System.out.println(prod);

        for (int i = 1000; 500 <= i; i -= 10) {
            System.out.println(i);
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(Math.sqrt(i));
        }

        for (int i = 1; i <= 500; i++) {
            if (i % 3 != 0) {
                System.out.println(i);
            }
        }

        for (int i = 1; i <= 200; i++) {
            if (i % 2 != 0 && i % 5 != 0) {
                System.out.println(i);
            }
        }


        // Math.pow(4, i) 4 nek az i-edik hatványa
        for (int i = 1; Math.pow(4, i) <= 10000; i++) {
            System.out.println((int) Math.pow(4, i));
            //sout(int) ".0" törlés a számok végéről, mert alapból legegő pontos számot ad.
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number what you think will be a perfect square number: ");
        int number = scanner.nextInt();

        double numberSquare = Math.sqrt(number); // eltárlomon a bekért szám négyzetgyökét egy double típusú változóban
        if (numberSquare == (int) numberSquare) {
            //Azt vizsgáljuk, hogy a double bekért érték egyenlő-e az int értékkel!!
            //pl: 16-nak a négyzetgyöke double értékben: 4.0 == int 4-el!!!
            //pl: 10 nek ~ double 3.16 != int 3.16 mert nincs ilyen!!
            System.out.println(number + " This number is Perfectly square");
        } else {
            System.out.println(number + " This number isn't square");
        }
        scanner.close();


        int largestPrimeNumber = 0;
        for (int i = 2; i < 500; i++) { // i = vizsgáladó szám
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) { // j == vizsgáló szám
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                largestPrimeNumber = i;
            }
        }
        System.out.println(largestPrimeNumber);

        int sumOfSqrt = 0;
        for (int i = 1; i <= 100; i++) {
            if (Math.sqrt(i) == (int) Math.sqrt(i)) {
                //ugyan úgy megvizsgálom hogy a double érték == az int értékkel!!
                sumOfSqrt += i;
            }
        }
        System.out.println(sumOfSqrt);
    }
}
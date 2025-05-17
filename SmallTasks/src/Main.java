import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //       double firstNumber = 0.1;
        //       double secoundNumber = 0.2;
        //       double sum = firstNumber + secoundNumber;

        //       System.out.println(sum);
/*
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secoundNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();

        if(firstNumber+secoundNumber+thirdNumber == 180){
            System.out.println("The sum equals with 180!");
        }
        else {
            System.out.println("The sum is not equals with 180!");
        }

 */
/*

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number < 80) {
            System.out.println("the number less than 80");
        } else if (80 < number) {
            System.out.println("the number bigger than 80");
        } else {
            System.out.println("the number equals to 80");
        }







        Scanner scanner1 = new Scanner(System.in);
        int number1 = scanner1.nextInt();

        if (number1 % 7 == 0) {
            System.out.println("the number is divisible by 7");
        } else {
            System.out.println("the number isn't divisible by 7");
        }



        Scanner scannertwo = new Scanner(System.in);

        int number = scannertwo.nextInt();

        if (number < 0) {
            System.out.println("the number negative");
        } else if (number == 0) {
            System.out.println("the number equals 0");
        } else {
            System.out.println("the number positive");
        }

        Scanner scannerthree = new Scanner(System.in);
        int first = scannerthree.nextInt();
        int first2 = scannerthree.nextInt();
        int first3 = scannerthree.nextInt();
        int first4 = scannerthree.nextInt();

        if(first + first2 + first3 == first4){
            System.out.println("the 4. number is equal to the sum");
        }else {
            System.out.println("the 4. number is not equal to the sum");
        }



        Scanner scanner2 = new Scanner(System.in);
        float floatingNumber = scanner2.nextFloat();

        if (floatingNumber * 6 < 100) {
            System.out.println("then number isn't bigger than 100");
        } else if (100 < floatingNumber * 6) {
            System.out.println("the number bigger than 100");
        } else {
            System.out.println("the number is equal to 100");
        }




        Scanner scanner3 = new Scanner(System.in);


        System.out.println("please enter a text: ");

        String text = scanner3.nextLine();

        int numbers = text.length();

        System.out.println(numbers);



        Scanner scanner3 = new Scanner(System.in);


        System.out.println("please enter a text: ");

        String text = scanner3.nextLine();

        System.out.println("please enter a nother text: ");

        String text1 = scanner3.nextLine();

        int sum = text.length()+ text1.length();

        System.out.println(sum);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("Enter a text: ");
        String text = scanner.nextLine();
        int letters = text.length();

        if(letters < number){
            System.out.println("The text letters longer than the number!");
        }else if(number < letters){
            System.out.println("The text letters shorter than numbers!");
        }else {
            System.out.println("The text letters and the number are equal!");
        }
*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();
        System.out.println("Enter the third number: ");
        int thirdNumber = scanner.nextInt();
// ha az első a legnagyobb
        if (firstNumber > secondNumber && firstNumber > thirdNumber) {
            System.out.println("→ the first number is the greatest");
// ha a második a legnagyobb
        } else if (secondNumber > firstNumber && secondNumber > thirdNumber) {
            System.out.println("→ the second number is the greatest");
// ha a 3. a legnagyobb
        } else if (thirdNumber > firstNumber && thirdNumber > secondNumber) {
            System.out.println("→ the third number is the greatest");
            // ha az első és a mádosik
        } else if (firstNumber == secondNumber && firstNumber > thirdNumber) {
            System.out.println("→ the first and the second number are the greatest");
            // ha az első és a 3.
        } else if (firstNumber == thirdNumber && firstNumber > secondNumber) {
            System.out.println("→ the first and the third number are the greatest");
            // ha a második és a harmadik
        } else if (secondNumber == thirdNumber && secondNumber > firstNumber) {
            System.out.println("→ the second and the third number are the greatest");
            // ha a mindegyik
        } else {
            System.out.println("→ all number are the same");
        }
    }
}
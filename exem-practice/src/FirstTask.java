//Write a program that asks 5 numbers from the user and prints to the
//console whether they are perfect squares AND even numbers or not

import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int number : array) {
            if (Math.sqrt(number) % 1 == 0 && number % 2 == 0) {
                System.out.print("true ");
            } else {
                System.out.print("false ");
            }
        }
    }
}
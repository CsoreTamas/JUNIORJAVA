//Write a program that asks the user to enter 6 numbers, then prints the square root of
// the difference between the largest and smallest number.

import java.util.Scanner;

public class SecondTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[6];
        int smallestNumber = array[0];
        int greatestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (array[i] < smallestNumber) {
                smallestNumber = array[i];
            } else if (array[i] > greatestNumber) {
                greatestNumber = array[i];
            }
        }
        System.out.println(Math.sqrt(greatestNumber - smallestNumber));
    }
}

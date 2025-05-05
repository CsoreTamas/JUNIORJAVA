//Write a program that asks for 6 numbers and prints the result of:
//(sum of the even numbers) - (sum of the odd numbers)

import java.util.Scanner;

public class ThirdTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[6];
        int sumOfEvenNumbers = array[0];
        int sumOfOddNumbers = array[0];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (array[i] % 2 == 1) {
                sumOfOddNumbers += array[i];
            } else {
                sumOfEvenNumbers += array[i];
            }
        }
        System.out.println(sumOfEvenNumbers - sumOfOddNumbers);

    }
}

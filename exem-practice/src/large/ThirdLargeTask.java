//Ask 3 numbers from the user and create the first 10 elements of the
//Tribonacci-sequence, starting with those 3 numbers. A Tribonacci-sequence
//is a sequence where the first 3 elements are given and each subsequent element
//is the sum of the previous three elements.
//Write unit tests for your Tribonacci-generation

import java.util.Arrays;
import java.util.Scanner;

public class ThirdLargeTask {
    public static void main(String[] args) {
        int[] array = getThreeNumber();
        System.out.println(Arrays.toString(calculateTribonacciSequence(array)));
    }

    public static int[] getThreeNumber() {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        System.out.print("Please enter three number: ");
        for (int i = 0; i < 3; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] calculateTribonacciSequence(int[] array) {
        for (int i = 3; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        return array;
    }
}

//Write a method that multiplies odd-indexed elements by 2, sums them and subtracts
// even-indexed elements from it. Test your code properly.

public class ForthMediumTask {
    public static void main(String[] args) {
        System.out.println(calculateSpecialSum(1, 2, 3, 4));
    }

    public static int calculateSpecialSum(int... array) {
        int sumOfEvenNUmber = 0;
        int sumOfOddNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sumOfEvenNUmber += array[i];
            } else {
                sumOfOddNumber += 2 * array[i];
            }
        }
        return sumOfOddNumber - sumOfEvenNUmber;
    }
}

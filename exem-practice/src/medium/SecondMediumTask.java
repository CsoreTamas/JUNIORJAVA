// Write a method that multiplies each element in an array with its index and returns the total sum. Test your code properly

public class SecondMediumTask {
    public static void main(String[] args) {
        System.out.println(multiplyNumbersWithTheirIndexAndGetTheSum(2, 4, 6));
    }

    public static int multiplyNumbersWithTheirIndexAndGetTheSum(int... array) {
        int sumOfElements = 0;
        for (int i = 0; i < array.length; i++) {
            sumOfElements += array[i] * i;
        }
        return sumOfElements;
    }
}

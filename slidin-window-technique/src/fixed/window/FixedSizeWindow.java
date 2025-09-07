package fixed.window;

public class FixedSizeWindow {
    public static int getMaxSumSlidingWindow(int[] array, int windowSize) {
        if (array == null) {
            throw new IllegalArgumentException("Array can't be null");
        } else if (windowSize > array.length) {
            throw new IllegalArgumentException("Window size must be lower than array length");
        } else if (windowSize <= 0) {
            throw new IllegalArgumentException("Window size must be greater than 0");
        }

        int maxSum = 0;
        int windowSum = 0;

        //Calculate the sum of the first windowSize elements of the array.
        for (int i = 0; i < windowSize; i++) {
            windowSum += array[i];
        }
        maxSum = windowSum;

        //Slide the window over the array starting from windowSize.
        for (int i = windowSize; i < array.length; i++) {
            //array[i] -> new element // array[i-windowSize] -> removed element
            // 1  2  3  4  5  6  7  8  // windowSize = 2
            //array[i] = 3 - array[i-windowSize] = 1
            //array[i] = 4 - array[i-windowSize] = 2
            //array[i] = 5 - array[i-windowSize] = 3
            //etc.
            windowSum += array[i] - array[i - windowSize];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        return maxSum;
    }
}

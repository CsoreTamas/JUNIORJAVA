package dynamic.window;

public class DynamicSizeWindow {
    public static int findSmallestSubArray(int[] array, int sum) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array length can't be null");
        } else if (sum <= 0) {
            throw new IllegalArgumentException("Sum must be greater than 0");
        }
        int start = 0; // starting index
        int windowSum = 0; // current sum of element inside the window
        int minLength = Integer.MAX_VALUE; // length of the smallest

        for (int end = 0; end < array.length; end++) { // 'end' is the ending index of the window
            windowSum += array[end]; //until sum >= given number
            while (windowSum >= sum) {
                //minLength lower than current subarray length?
                //and - start + 1 -->
                //end = 3 | start = 0 --> 4 elements (indexes 0,1,2,3)
                //end = 6 | start = 4 --> 3 elements (indexes 4,5,6)
                //we add 1 to the difference to get the current length
                minLength = Math.min(minLength, end - start + 1);
                // remove starting index of the array
                windowSum -= array[start];
                //slide the window forward
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
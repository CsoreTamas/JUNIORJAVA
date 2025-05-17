// Write a method that applies a repeating multiplier pattern of 1, 2, -1, -2 to the
// array and returns the total sum. Test your code properly.
public class ThirdMediumTask {
    public static void main(String[] args) {
        System.out.println(calculateWierdSumPattern(-2, -2, -2, -2));
    }

    public static int calculateWierdSumPattern(int... array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 4 == 0) {
                sum += array[i];
            } else if (i % 4 == 1) {
                sum += array[i] * 2;
            } else if (i % 4 == 2) {
                sum += -array[i];
            } else {
                sum += -2 * array[i];
            }
        }
        return sum;
    }
}

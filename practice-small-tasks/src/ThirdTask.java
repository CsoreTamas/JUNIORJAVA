import java.util.Arrays;

public class ThirdTask {
    public static void main(String[] args) {
        System.out.println(calculateModeToMedianPower(3, 4, 5, 6, 7, 89, 123, 0, 2, 3, 4, 5, 76, 43, 2));
    }

    public static double calculateModeToMedianPower(int... array) {
        int mode = getMode(array);
        double median = getMedian(array);
        return Math.pow(mode, median);
    }

    public static int getMode(int... array) {
        int counter = 0;
        int mode = array[0];

        for (int number : array) {
            int count = 0;

            for (int numbers : array) {
                if (number == numbers) {
                    ++count;
                }
            }

            if (count > counter) {
                counter = count;
                mode = number;
            }
        }

        return mode;
    }

    public static double getMedian(int... array) {
        Arrays.sort(array);
        if (array.length / 2 == 0) {
            return array[array.length / 2];
        } else {
            return (double) (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        }
    }
}
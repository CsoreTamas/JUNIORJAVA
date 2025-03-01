public class Task4 {
    public static void main(String[] args) {

        int[] numbers = {2, 5, 8, 3, 6, 7, 9, 4, 1};
        // 2  5  8  3  6  7  9  4  1
        // 0  1  2  3  4  5  6  7  8
        // +  +  +  !  +  +  +  !  +
        // 0  1  2  3  0  1  2  3  0
        int numbersSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i % 4 != 3) {
                numbersSum += numbers[i];
            }
        }
        System.out.println(numbersSum);
    }
}

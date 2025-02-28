public class Task10 {
    public static void main(String[] args) {

        int[] numbers = {-3, 4, -1, 7, -2, 8};
        int numbersSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                // ide is lehet kéne valami
            } else {
                numbersSum += numbers[i];
            }
        }
        System.out.println(numbersSum);
    }
}

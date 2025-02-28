public class Task7 {
    public static void main(String[] args) {
        int[] numbers = {5, 9, 7, 6, 2, 12, 8};

        int numbersSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 3 == 0) {
                //ide is kéne valamit írnom szerintem.
            } else {
                numbersSum += numbers[i];
            }
        }
        System.out.println(numbersSum);
    }
}

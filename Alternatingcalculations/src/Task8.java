public class Task8 {
    public static void main(String[] args) {

        int[] numbers = {3, 4, 5, 6};
        int numbersSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            // azért indulunk i = 0-ról, mert  a 0 a tömb indexét jelzi!!!
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(numbers[i]); j++) {
                //azért j = 2, mert 0-val és 1-el nem érdemes ellenőrizni
                if (numbers[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                numbersSum += numbers[i] * numbers[i];
            } else {
                numbersSum += numbers[i];
            }
        }
        System.out.println(numbersSum);

    }
}

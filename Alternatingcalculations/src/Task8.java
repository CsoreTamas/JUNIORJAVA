public class Task8 {
    public static void main(String[] args) {

        int[] numbers = {3, 4, 5, 6};
        int numbersSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            // azért indulunk i = 0-ról, mert  a 0 a tömb indexét jelzi!!!
            int currentlyNumber = numbers[i];
            // numbers[] tömb i-edig elemét elmentünk egy változóba.
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(currentlyNumber); j++) {
                //azért j = 2, mert 0-val és 1-el nem érdemes ellenőrizni
                if (currentlyNumber % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                numbersSum += currentlyNumber * currentlyNumber;
            } else {
                numbersSum += currentlyNumber;
            }
        }
        System.out.println(numbersSum);
    }
}

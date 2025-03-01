public class Task8 {
    public static void main(String[] args) {

        int[] numbers = {1, 3, 4, 5, 6};
        int numbersSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            // azért indulunk i = 0-ról, mert  a 0 a tömb indexét jelzi!!!
            int currentNumber = numbers[i];
            // numbers[] tömb i-edig elemét elmentünk egy változóba.
            boolean isPrime = currentNumber != 1;
            // boolean isPrime = true; + if ( currentNumber == 1){
                                            // isPrime = false;
                                            // }
            // külön lekezelem az 1 -et, hogy ha tömben lévő szám = 1 akkor isPrime HAMIS!!
            for (int j = 2; j <= Math.sqrt(currentNumber); j++) {
                //azért j = 2, mert 0-val és 1-el nem érdemes ellenőrizni
            if (currentNumber % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                numbersSum += currentNumber * currentNumber;
            } else {
                numbersSum += currentNumber;
            }
        }
        System.out.println(numbersSum);
    }
}

public class Task11 {
    public static void main(String[] args) {

        int[] numbers = {2, 3, -5, 4, -2};
        // a pozitiv számokat és a nevatív számokat össze szorozni majd elosztani
        // a pozitív számok szorzatát a negatív számok szorzatával!!!
        double negativeNumber = 1;
        double positiveNumber = 1;
        double numbersSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                negativeNumber *= numbers[i];
            } else {
                positiveNumber *= numbers[i];
            }
            numbersSum = positiveNumber / negativeNumber;
        }
        System.out.println(numbersSum);
    }
}

public class Task11 {
    public static void main(String[] args) {

        int[] numbers = {2, 3, -5, 4, -2};
        // a pozitiv számokat és a nevatív számokat össze szorozni majd elosztani
        // a pozitív számok szorzatát a negatív számok szorzatával!!!
        double negativeProduct = 1;
        double positiveProduct = 1;
        double numbersSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                negativeProduct *= numbers[i];
            } else {
                positiveProduct *= numbers[i];
            }
            numbersSum = positiveProduct / negativeProduct;
        }
        System.out.println(numbersSum);
    }
}

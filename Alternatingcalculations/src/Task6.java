public class Task6 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //0  1  2  3  4  5  6  7  8  9  10 11 12
        //+  + +*2 +  + +*2 +  + +*2 +  + +*2 +
        //0  1  2  0  1  2  0  1  2  0  1  2  0
        int numbersSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i % 3 == 2) {
                int arrayThirdNum = numbers[i] * 2;
                //többnek az i-edik elemét megszorzom
                // kettővel és azt eltárolom egy változóba
                numbersSum += arrayThirdNum;
            } else {
                numbersSum += numbers[i];
            }
        }
        System.out.println(numbersSum);

    }
}

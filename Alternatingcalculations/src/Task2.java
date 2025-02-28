public class Task2 {
    public static void main(String[] args) {

        int[] numbers = {2, 3, 6, 4, 2, 8, 3, 7, 9};
        //n1×n2÷n3×n4×n5÷n6×n7×n8÷n9…
        //0  1  2  3  4  5  6  7  8
        //+  *  /  *  *  /  *  *  /
        //0  1  2  0  1  2  0  1  2
        float numbersSum = 1;
        for (int i = 0; i < numbers.length; i++) {
            if (i % 3 == 2) {
                numbersSum /= numbers[i];
            } else {
                numbersSum *= numbers[i];
            }
        }
        System.out.println(numbersSum);
    }
}

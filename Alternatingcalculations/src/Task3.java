public class Task3 {
    public static void main(String[] args) {

        int[] numbers = {10, 5, 3, 2, 8, 6};
        //n0−n1+n2−n3+n4−n5+…
        //+  -  +  -  +  -
        //0  1  0  1  0  1
        int numbersSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                numbersSum += numbers[i];
            } else {
                numbersSum -= numbers[i];
            }
        }
        System.out.println(numbersSum);
    }
}

public class AlternatingCalculations {
    public static void main(String[] args) {

        int[] numbers = {3, 5, 2, 7, 4, 8, 1, 6, 9};
        //n1+n2−n3+n4+n5−n6+n7+n8−n9
        //0  1  2  3  4  5  6  7  8
        //+  +  -  +  +  -  +  +  -
        //0  1  2  0  1  2  0  1  2
        int numbersSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i % 3 == 2) {
                numbersSum -= numbers[i];
            } else {
                numbersSum += numbers[i];
            }
        }
        System.out.println(numbersSum);


        /*
        You can see somewhere I left empty body in if statement cause I don't really know what do I
        have to do. I feel like I have to put something in the body. When I put "continue;" it doesn't
        anything if I put "break;" it's ruin the code.
         */
    }
}
public class Task5 {
    public static void main(String[] args) {

        int[] numbers = {2, 3, 4, 2, 5, 2, 8, 3};
        if (numbers.length % 2 == 1) {
            System.err.println("Error, the array have to be even!");
        }
        double numbersSum = 1.0f;
        //n1^n2÷n3^n4×n5^n6÷n7^n8×n9^n10
        //  0 1   2 3   4 5   6 7   8 9
        // (+^+)/(+^+)*(+^+)/(+^+)*(+^+)
        //
        for (int i = 0; i < numbers.length; i += 2) { // azért i +=2, mert így párosítjuk össze
            // a hatványozandó számot "kiemeli" és ugye mivel 2-vel lépkedünk a tömbben
            // azt a számot ami a 1 es Indexen helyezkedik már eltároltuk egy változóban.

            // összepárosítjuk és eltároljuk a hatványozni kívánt számokat.
            int num = numbers[i]; // hatványozandó szám
            int powerOfTheNumber = numbers[i + 1]; // hatványa a számnak

            double power = Math.pow(num, powerOfTheNumber);
            //kiszámoljuk az összepárosított hatványozásokat
            // 8 / 16 * 25 / 512
            if (i % 4 == 2) {
                numbersSum /= power;
            } else {
                numbersSum *= power;
            }
        }
        System.out.println(numbersSum);
    }
}

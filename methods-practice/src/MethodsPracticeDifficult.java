import java.util.Arrays;

public class MethodsPracticeDifficult {
    public static void main(String[] args) {

        //14)
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        System.out.println(sumOfTheArray(array));

        //15)
        int[][] array1 = {
                {2, 2, 2},
                {3, 3, 3, 3},
                {10, 10}};
        System.out.println(Arrays.toString(sumOfRowsInArray(array1)));
        //Arrays.toString() --> tömb kiírása miatt szükséges!!

        //16)
        int[][] array3 = {
                {1, 2, 3, 4},
                {4, 3, 2, 1},
                {1, 2, 3, 4},
                {4, 3, 2, 1}};
        System.out.println(sumOfMainDiagonal(array3));

int[][] array4 = {
                {1, 2, 3, 4},
                {4, 3, 2, 1},
                {1, 2, 3, 4},
                {4, 3, 2, 1}};
        System.out.println(calculateDiagonalDifference(array4));

        //17)

    }
    //14)

    public static int sumOfTheArray(int[][] array) {
        int sum = 0;
        //létrehozok 1 int változót
        for (int i = 0; i < array.length; i++) {
            //i = tömb sorai
            for (int j = 0; j < array[i].length; j++) {
                //j = tömb oszlopai
                sum += array[i][j];
                //összeadom a tömb I-edik (sor) és J-edik (oszlop) adott elemét.
                //pl: i = 2 , j = 1 --> 8!!
            }
        }
        return sum;
    }

    //15)
    public static int[] sumOfRowsInArray(int[][] twoDimensionalArray) {
        int[] rowSums = new int[twoDimensionalArray.length];
        //létrehozok 1 tömböt ami olyan hosszú amennyi sora van az twoDimensionalArray-nek

        for (int i = 0; i < twoDimensionalArray.length; i++) {
            int sum = 0;
            //létrehozok 1 változót amihez majd hozzáadom a tömb oszlopainak összegét
            //azért hozom létre itt, mert ha a for loop előtt hozom létre, akkor
            //a 0. sor összegével kezdi az 1. sor összegét és nem 0-ról mint a változó!!
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                //végigmegyek a tömb oszlopain
                sum += twoDimensionalArray[i][j];
                //elmentem az oszlopok összegeit egy változóba
            }
            rowSums[i] = sum;
            // itt belerakom a változót a forloop előtt létrehozott tömb i-edik helyére.
        }
        return rowSums;
    }

    //16)
    public static int sumOfMainDiagonal(int[][] array) {
        int diagonalSum = 0;
        for (int i = 0; i < array.length; i++) {
            //végig megyek a tömbön.
            diagonalSum += array[i][i];
            //és a tömb i. sorába i. oszlopába lévő elemet adom hozzá a változóhoz.
            //azaz a tömb sor és oszop számai egyenletesen növekednek.
        }
        return diagonalSum;
    }

    //17)
    public static int calculateDiagonalDifference(int[][] array) {
        int mainDiagonalResult = sumOfMainDiagonal(array);

        for (int i = 0; i < array.length; i++) {
            mainDiagonalResult -= array[i][array.length - 1 - i];
            //a változóból kivonom a tömb i-edik sorában lévő tömbhossz-1-i edik elemet
            //ami: array.length - 1 = tömb utolsó oszopának indexe és azért -1, mivel a tömb indexelése
            //0-ról indul. "- i" = azért vonom ki az i-t mert így egyeneletesen fogok visszafele haladni
            //annyival amennyivel a sorok száma nő!!!
        }
        return mainDiagonalResult;
    }
}

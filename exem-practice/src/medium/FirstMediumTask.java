// Write a method that receives a 4D array of booleans and returns whether all values are true.

public class FirstMediumTask {

    public static boolean decideIsTrue(boolean[][][][] array) {
        for (boolean[][][] lvl1 : array) {
            for (boolean[][] lvl2 : lvl1) {
                for (boolean[] lvl3 : lvl2) {
                    for (boolean value : lvl3) {
                        if (!value) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

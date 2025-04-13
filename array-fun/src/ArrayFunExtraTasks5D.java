import java.util.Arrays;

public class ArrayFunExtraTasks5D {

    public static int countTheStringsWhichNotHaveEOrR(String[][][][][] array) {
        int stringCounter = 0;
        for (String[][][][] subArray : array) {
            for (String[][][] subSubArray : subArray) {
                for (String[][] subSubSubArray : subSubArray) {
                    for (String[] subSubSubSubArray : subSubSubArray) {
                        for (String strings : subSubSubSubArray) {
                            if (!isChar(strings)) {
                                stringCounter++;

                            }
                        }
                    }
                }
            }
        }
        return stringCounter;
    }

    private static boolean isChar(String strings) {
        for (int i = 0; i < strings.length(); i++) {
            char ch = strings.charAt(i);
            if (ch == 'E' || ch == 'e' || ch == 'r') {
                return true;
            }
        }
        return false;
    }

    public static int[][][][][] fillTheArrayWithStringsLength(String[][][][][] array) {
        int[][][][][] resultArray = new int[array.length][][][][];

        for (int i = 0; i < array.length; i++) {
            resultArray[i] = new int[array[i].length][][][];

            for (int j = 0; j < array[i].length; j++) {
                resultArray[i][j] = new int[array[i][j].length][][];

                for (int k = 0; k < array[i][j].length; k++) {
                    resultArray[i][j][k] = new int[array[i][j][k].length][];

                    for (int l = 0; l < array[i][j][k].length; l++) {
                        resultArray[i][j][k][l] = new int[array[i][j][k][l].length];

                        for (int m = 0; m < array[i][j][k][l].length ; m++) {
                            resultArray[i][j][k][l][m] = array[i][j][k][l][m].length();
                        }
                    }
                }
            }
        }
        return resultArray;
    }

    public static String

    public static void main(String[] args) {
        String[][][][][] testArray = {
                {
                        {
                                {
                                        {"one", "two"},
                                        {"char", "car"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"error", "factor"},
                                        {"get", "hello"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"is", "window"},
                                        {"BED", "TV"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"bad", "Pillow"},
                                        {"telephone", "stock"}
                                }
                        }
                }
        };
        System.out.println(Arrays.deepToString(fillTheArrayWithStringsLength(testArray)));
    }
}

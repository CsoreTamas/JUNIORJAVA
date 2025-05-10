import java.util.ArrayList;
import java.util.List;

public class ArrayFunExtraTasks4D {

    public static int countLowercaseStrings(String[][][][] array) {
        int counter = 0;
        for (String[][][] subArray : array) {
            for (String[][] subSubArray : subArray) {
                for (String[] subSubSubArray : subSubArray) {
                    for (String strings : subSubSubArray) {
                        boolean low = true;
                        for (int i = 0; i < strings.length(); i++) {
                            if (!Character.isLowerCase(strings.charAt(i))) {
                                low = false;
                                break;
                            }
                        }
                        if (low) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }

    public static String[][][][] reverseAllStringInTheArray(String[][][][] array) {
        String[][][][] resultArray = new String[array.length][][][];
        for (int i = 0; i < array.length; i++) {
            resultArray[i] = new String[array[i].length][][];
            for (int j = 0; j < array[i].length; j++) {
                resultArray[i][j] = new String[array[i][j].length][];
                for (int k = 0; k < array[i][j].length; k++) {
                    resultArray[i][j][k] = new String[array[i][j][k].length];
                    for (int l = 0; l < array[i][j][k].length; l++) {
                        StringBuilder stringBuilder = new StringBuilder(array[i][j][k][l]);
                        stringBuilder.reverse();
                        resultArray[i][j][k][l] = stringBuilder.toString();
                    }
                }
            }
        }
        return resultArray;
    }

    public static int calculateTheAverageOfStrings(String[][][][] array) {
        int result = 0;
        int divisor = 0;
        for (String[][][] subArray : array) {
            for (String[][] subSubArray : subArray) {
                for (String[] subSubSubArray : subSubArray) {
                    for (String strings : subSubSubArray) {
                        divisor++;
                        result += strings.length();
                    }
                }
            }
        }
        double average = (double) result / divisor;
        return (int) Math.floor(average);
    }

    public static List<String> searchStringsWithMoreThanTwoVowels(String[][][][] array) {
        List<String> resultList = new ArrayList<>();
        for (String[][][] subArray : array) {
            for (String[][] subSubArray : subArray) {
                for (String[] subSubSubArray : subSubArray) {
                    for (String strings : subSubSubArray) {
                        int vowels = 0;
                        for (int i = 0; i < strings.length(); i++) {
                            char ch = strings.charAt(i);
                            if (isVowel(ch)) {
                                vowels++;
                            }
                        }
                        if (vowels > 2) {
                            resultList.add(strings);
                        }
                    }
                }
            }
        }
        return resultList;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static String getTheShortestString(String[][][][] array) {
        String shortestString = array[0][0][0][0];
        for (String[][][] subArray : array) {
            for (String[][] subSubArray : subArray) {
                for (String[] subSubSubArray : subSubArray) {
                    for (String currentString : subSubSubArray) {
                        if (currentString.length() < shortestString.length()) {
                            shortestString = currentString;
                        }
                    }
                }
            }
        }
        return shortestString;
    }

    public static void main(String[] args) {
    }
}


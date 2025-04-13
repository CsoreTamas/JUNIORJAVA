import java.util.Arrays;

public class ArrayFunExtraTasks3D {

    public static int getTheNumberOfPalindromesStrings(String[][][] array) {
        int numberOfPalindromes = 0;
        for (String[][] subText : array) {
            for (String[] subText1 : subText) {
                for (String subText2 : subText1) {
                    if (subText2.contentEquals(new StringBuilder(subText2).reverse())) {
                        numberOfPalindromes++;
                    }
                }
            }
        }
        return numberOfPalindromes;
    }

    public static int[] countStringsInSubSubArray(String[][][] array) {
        int[] resultArray = countElements(array);
        int index = 0;
        for (String[][] strings : array) {
            for (String[] string : strings) {
                resultArray[index] = string.length;
                index++;
            }
        }
        return resultArray;
    }

    public static int[] countElements(String[][][] array) {
        int counter = 0;
        for (String[][] strings : array) {
            for (int j = 0; j < strings.length; j++) {
                counter++;
            }
        }
        return new int[counter];
    }

    public static String concatenateAllStringWitchLongerThan2(String[][][] array) {
        StringBuilder string = new StringBuilder();
        for (String[][] subText : array) {
            for (String[] subText1 : subText) {
                for (String subText2 : subText1) {
                    if (subText2.length() > 2) {
                        string.append(subText2);
                    }
                }
            }
        }
        return string.toString();
    }

    public static int getTheLongestStringLength(String[][][] array) {
        int longestString = 0;
        for (String[][] subText : array) {
            for (String[] subText1 : subText) {
                for (String subText2 : subText1) {
                    if (subText2.length() > longestString) {
                        longestString = subText2.length();
                    }
                }
            }
        }
        return longestString;
    }

    public static boolean searchAnySAtThe3rdArray(String[][][] array) {
        for (String[][] strings : array) {
            for (String[] string : strings) {
                boolean haveSAtTheEnd = false;
                for (String str : string)
                    if (str.endsWith("s")) {
                        haveSAtTheEnd = true;
                        break;
                    }
                if (!haveSAtTheEnd) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

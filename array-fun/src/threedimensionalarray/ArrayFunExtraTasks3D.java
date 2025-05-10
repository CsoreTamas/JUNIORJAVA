import java.util.Arrays;

public class ArrayFunExtraTasks3D {

    public static int getTheNumberOfPalindromesStrings(String[][][] array) {
        int numberOfPalindromes = 0;
        for (String[][] subArray : array) {
            for (String[] subSubArray : subArray) {
                for (String strings : subSubArray) {
                   if (isPalindrome(strings)){
                       numberOfPalindromes++;
                   }
                }
            }
        }
        return numberOfPalindromes;
    }

    public static boolean isPalindrome(String string) {
        return string.contentEquals(new StringBuilder(string).reverse());
    }

    public static int[] countStringsInSubSubArray(String[][][] array) {
        int[] resultArray = countElements(array);
        int index = 0;
        for (String[][] subArray : array) {
            for (String[] strings : subArray) {
                resultArray[index] = strings.length;
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
        for (String[][] subArray : array) {
            for (String[] subSubArray : subArray) {
                for (String strings : subSubArray) {
                    if (strings.length() > 2) {
                        string.append(strings);
                    }
                }
            }
        }
        return string.toString();
    }

    public static int getTheLongestStringLength(String[][][] array) {
        int longestString = 0;
        for (String[][] subArray : array) {
            for (String[] subSubArray : subArray) {
                for (String strings : subSubArray) {
                    if (strings.length() > longestString) {
                        longestString = strings.length();
                    }
                }
            }
        }
        return longestString;
    }

    public static boolean searchAnySAtThe3rdArray(String[][][] array) {
        for (String[][] subArray : array) {
            for (String[] subSubArray : subArray) {
                boolean haveSAtTheEnd = false;
                for (String strings : subSubArray) {
                    if (strings.endsWith("s")) {
                        haveSAtTheEnd = true;
                        break;
                    }
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

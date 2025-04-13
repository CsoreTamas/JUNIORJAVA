import java.util.Arrays;

public class ArrayFun {
    public static double getTheAverageOfEvenNumbers(int[] array) {
        int counter = 0;
        int result = 0;
        for (int number : array) {
            if (number % 2 == 0 && number != 0) {
                result += number;
                counter++;
            }
        }
        return (double) result / counter;
    }

    public static int[] getTheOddNumbersSquare(int[] array) {
        int[] resultArray = new int[countElements(array)];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (isOdd(array[i])) {
                resultArray[j] = (int) Math.pow(array[i], 2);
                j++;
            }
        }
        return resultArray;
    }

    public static boolean isOdd(int number) {
        return Math.abs(number % 2) == 1;
    }

    public static int countElements(int[] array) {
        int counter = 0;
        for (int number : array) {
            if (isOdd(number)) {
                counter++;
            }
        }
        return counter;
    }

    public static int getTheNumberOfStringsStartingWithA(String[] strings) {
        int counter = 0;
        for (String string : strings) {
            if (string.charAt(0) == 'a' || string.charAt(0) == 'A') {
                counter++;
            }
        }
        return counter;
    }

    public static String concatenateAllStringWhichLongerThan3Char(String[] strings) {
        StringBuilder resultStringBuilder = new StringBuilder();
        for (String string : strings) {
            if (string.length() > 3) {
                resultStringBuilder.append(string);
            }
        }
        return resultStringBuilder.toString();
    }

    public static boolean searchAnyDuplication(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static int countTheVowels(String[][] array) {
        int counter = 0;
        for (String[] strings : array) {
            for (String string : strings) {
                for (int k = 0; k < string.length(); k++) {
                    char ch = string.charAt(k);
                    if (isVowel(ch)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static int calculateTheSumOfTheLengthsOfTheLongestStrings(String[][] array) {
        int result = 0;
        for (String[] strings : array) {
            String longestString = "";
            longestString = getLongestString(strings, longestString);
            result += longestString.length();
        }
        return result;
    }

    public static String getLongestString(String[] strings, String longestString) {
        for (String string : strings) {
            if (string.length() > longestString.length()) {
                longestString = string;
            }
        }
        return longestString;
    }

    public static String[] getTheAllStringsInUppercase(String[][] array) {
        int allStringsCount = 0;
        for (String[] value : array) {
            allStringsCount += value.length;
        }
        String[] allString = new String[allStringsCount];
        int index = 0;
        for (String[] coulombs : array) {
            for (String rows : coulombs) {
                allString[index] = rows.toUpperCase();
                index++;
            }
        }
        return allString;
    }

    public static boolean[][] searchAnyNumberInTheStrings(String[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        boolean[][] resultArray = new boolean[rows][columns];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String actualString = array[i][j];
                resultArray[i][j] = false;
                for (int k = 0; k < actualString.length(); k++) {
                    char ch = actualString.charAt(k);
                    if (Character.isDigit(ch)) {
                        resultArray[i][j] = true;
                        break;
                    }
                }
            }
        }
        return resultArray;
    }

    public static double calculateAverageOfStrings(String[][] array) {
        int result = 0;
        int divisor = 0;
        for (String[] strings : array) {
            for (String string : strings) {
                divisor++;
                result += string.length();
            }
        }
        return (double) result / divisor;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 4, 5, 6, 7, 8, 10};
        System.out.println(getTheAverageOfEvenNumbers(array));
        int[] testArray = {2, 3, 4, 5, 6, 7, 8, 9, 0, -2, -3, -4, -5};
        System.out.println(Arrays.toString(getTheOddNumbersSquare(testArray)));
        String[] stringTestArray = {"Hello", "Apple", "Anaconda", "append", "dog", "people"};
        System.out.println(getTheNumberOfStringsStartingWithA(stringTestArray));
        String[] strTestArray = {"Have a", "per", " good day", "Ho", "An", " dear", "end", "dog", " teacher", "! :)"};
        System.out.println(concatenateAllStringWhichLongerThan3Char(strTestArray));
        int[] intArray = {2, 1, 3, 4, 3, 5, 3, 1, 0, 1, 1, 2, 3};
        System.out.println(searchAnyDuplication(intArray));

        String[][] strings = {
                {"Hel2lo", "Dog", "Ca5t"},
                {"tabl3e", "TV", "char"},
                {"app1ly", "pear", "pe3acha"}
        };
        System.out.println((Arrays.deepToString(searchAnyNumberInTheStrings(strings))));

        String[][] averageStrings = {
                {"Hello", "Doges", "Casts"},
                {"table", "mouses", "chars"},
                {"apply", "pear", "peach"}
        };
        System.out.println(calculateAverageOfStrings(averageStrings));
    }
}
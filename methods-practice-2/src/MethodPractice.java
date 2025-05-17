public class MethodPractice {
    public static void main(String[] args) {
    }

    // 1. Writes your own name to the console
    public static void printMyOwnName() {
        System.out.println("Csőre Tamás");
    }

    // 2. Writes a welcome message to the console
    public static void printAWelcomeMessage() {
        System.out.println("Welcome in this perfect practice");
    }

    // 3. Gets in a number and returns its 30%
    public static double getNumber30Percent(int number) {
        return (double) (number * 30) / 100;
    }

    // 4. Gets in an array of Strings and returns an empty String
    public static String getAnEmptyString(String[] stings) {
        return "";
    }

    // 5. Gets in a number and returns its 42.8%
    public static double getANumber42Point8Percent(int number) {
        return number * 42.8 / 100;
    }

    // 6. Gets in a String and returns the double of its length
    public static int multiplyTheStringLengthByTwo(String string) {
        return string.length() * 2;
    }

    // 7. Gets in two numbers and returns how much you would need to add to the first number to get the second one
    public static int getTheDifference(int first, int second) {
        return second - first;
    }

    // 8. Gets in a String and returns the square root of its length
    public static double getTheStringLengthSquareRoot(String string) {
        return Math.sqrt(string.length());
    }

    // 9. Gets in a String and returns the factorial of its length
    public static int getTheStringLengthFactorial(String string) {
        int result = 1;
        for (int i = 1; i <= string.length(); i++) {
            result *= i;
        }
        return result; // 12
    }

    // 10. Gets in a number and returns 100 divided by that number
    public static double division100WithNumber(int number) {
        return (double) 100 / number;
    }

    // 11. Gets in a number and …
    // a. returns the square of it if it is prime
    // b. returns the double of it if it is not a prime and is divisible by 4
    // c. returns the triple of it if it is not a prime and is not divisible by 4
    public static int getANumberIf(int number) {
        if (isPrime(number)) {
            return number * number;
        } else if (number % 4 == 0) {
            return number * 2;
        } else {
            return number * 3;
        }
    }


    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 12. Gets in an array of Strings and returns a new array of numbers of each String’s length
    public static int[] getTheStringsLength(String[] array) {
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultArray[i] = array[i].length();
        }
        return resultArray;
    }

    // 13.Gets in a gross salary and calculates the net salary according to the Hungarian rules in the following way:
// a. deduces 15% as SZJA (personal income tax) and 18.5% as TBJ (social security tax)
// b. the remaining amount is going to be the net salary
// c. So if someone earns 100 000 HUF gross per month, their net salary is going to be 66500 HUF
// d. Use separate methods to calculate SZJA and TBJ.
    public static double calculateNetSalary(double number) {
        return (number - (calculatePersonalIncomeTax(number) + calculateSocialSecurityTax(number)));
    }

    public static double calculatePersonalIncomeTax(double number) {
        return number * 15 / 100;
    }

    public static double calculateSocialSecurityTax(double number) {
        return number * 18.5 / 100;
    }

    // 14. Gets in an array of booleans and returns a1 XOR a2 XOR a3 … XOR an
    public static boolean decideTrueOrFalse(boolean[] array) {
        boolean values = false;
        for (boolean result : array) {
            values ^= result;
        }
        return values;
    }

    // 15.Gets in an array of numbers and returns a new array with all the negative numbers in from the original array
    public static int[] filWithNumbersUnder0(int[] array) {
        int[] resultArray = new int[countElements(array)];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (isSmallerThan0(array[i])) {
                resultArray[j] = array[i];
                j++;
            }
        }
        return resultArray;
    }

    public static boolean isSmallerThan0(int number) {
        return number < 0;
    }

    public static int countElements(int[] array) {
        int counter = 0;
        for (int number : array) {
            if (isSmallerThan0(number)) {
                counter++;
            }
        }
        return counter;
    }
}


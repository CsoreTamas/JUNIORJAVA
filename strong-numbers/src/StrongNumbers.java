public class StrongNumbers {
    public static void main(String[] args) {
        System.out.println(decideStrongOrNot(145));
    }

    //O(9*x) (x meaning the number.charAT(i)
    public static int factorial(int number) {
        int digit = 1;
        for (int i = 1; i <= number; i++) {
            digit *= i;
        }
        return digit;
    }

    //O(1)
    public static int add(int digit, int sum) {
        return sum + digit;
    }
    
    //O(n)
    public static boolean decideStrongOrNot(int number) {
        //Convert int to String
        String stringNumber = Integer.toString(number);

        int sumOfFactorials = 0;
        int factorialDigit;
        for (int i = 0; i < stringNumber.length(); i++) {
            //Get the i-th element
            char index = stringNumber.charAt(i);
            //Character.getNumericValue() ---> Char to Numeric value!!
            int numericValue = Character.getNumericValue(index);
            factorialDigit = factorial(numericValue);
            sumOfFactorials = add(factorialDigit, sumOfFactorials);
        }
        return sumOfFactorials == number;
    }
}

// Could be O(n+9) ? --> O(n)
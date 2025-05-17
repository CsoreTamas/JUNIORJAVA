import java.math.BigInteger;
import java.util.Arrays;

public class Main {


    public static int calculateFibonacciValue(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return calculateFibonacciValue(number - 1) + calculateFibonacciValue(number - 2);
    }


    public static BigInteger calculateFibonacciValue(BigInteger number) {
        //Convert a primitive int to a BigInteger OBJECT!
        //int primitiveOne = 1;
        //BigInteger one = BigInteger.valueOf(primitiveOne);
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;

        // number           .compareTo                  (BigInteger.ZERO)                              == 0
        // the number       is compare       to      primitive 0 converted to an Object                are equal?
        if (number.equals(BigInteger.ZERO)) {
            return zero;
        }
        // == 0 means the number and the BigInteger.ONE(meaning 1) should be equal to
        if (number.equals(BigInteger.ONE)) {
            return one;
        }
        // If :
        //number             .compareTo                  (BigInteger.ONE)                        < 0
        //the number         is compare      to          primitive 1 converted to an Object      number < 1?

        //number             .compareTo                  (BigInteger.ONE)                        > 0
        //the number         is compare      to          primitive 1 converted to an Object      number > 1?


        //primitive number converted to an Object like primitive operations - and + converted to method calls.
        return calculateFibonacciValue(number.subtract(BigInteger.ONE)).add(calculateFibonacciValue(number.subtract(BigInteger.TWO)));
    }

    static BigInteger[] array = new BigInteger[1000];

    public static BigInteger calculateFibonacciValueShortCut(BigInteger number) {
        if (number.compareTo(BigInteger.TWO) < 1) {
            return BigInteger.valueOf(1);
        }

        BigInteger previous;
        BigInteger previousPrevious;

        //.intValue() for the indexes!!
        if (!array[number.subtract(BigInteger.ONE).intValue()].equals(BigInteger.ZERO)) {
            previous = array[number.subtract(BigInteger.ONE).intValue()];
        } else {
            previous = calculateFibonacciValueShortCut(number.subtract(BigInteger.ONE));
            array[number.subtract(BigInteger.ONE).intValue()] = previous;
        }
        if (!array[number.subtract(BigInteger.TWO).intValue()].equals(BigInteger.ZERO)) {
            previousPrevious = array[number.subtract(BigInteger.TWO).intValue()];
        } else {
            previousPrevious = calculateFibonacciValueShortCut(number.subtract(BigInteger.TWO));
            array[number.subtract(BigInteger.TWO).intValue()] = previousPrevious;
        }
        return previousPrevious.add(previous);
    }


    public static void main(String[] args) {
        //If the BigInteger[] array is empty, its indexes are null. We have to fill it with BigInteger.ZERO to run the code.
        //If we don't fill the array with ZERO, we would have to calculate with null, which doesn't work.
        Arrays.fill(array, BigInteger.ZERO);
        System.out.println(calculateFibonacciValueShortCut(BigInteger.valueOf(100)));
    }
}

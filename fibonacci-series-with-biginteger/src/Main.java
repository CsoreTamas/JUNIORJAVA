import java.math.BigInteger;

public class Main {

    public static int calculateFibonacciValue(int number) {
        if (number == 0) {
            return 0;
        }if (number == 1){
            return 1;
        }
        return calculateFibonacciValue(number - 1) + calculateFibonacciValue(number -2);
    }


    public static BigInteger calculateFibonacciValue(BigInteger number) {
        //Convert a primitive int to a BigInteger OBJECT!
        //int primitiveOne = 1;
        //BigInteger one = BigInteger.valueOf(primitiveOne);
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;

        // number           .compareTo                  (BigInteger.ZERO)                              == 0
        // the number       is compare       to      primitive 0 converted to an Object                are equal?
        if (number.compareTo(BigInteger.ZERO) == 0) {
            return zero;
        }
        // == 0 means the number and the BigInteger.ONE(meaning 1) are equals!!
        if (number.compareTo(BigInteger.ONE) == 0) {
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

    public static void main(String[] args) {
        System.out.println(calculateFibonacciValue(BigInteger.TEN));

    }
}
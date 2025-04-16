import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static void main(String[] args) {
        System.out.println(primes(100));
    }

    public static List<Integer> getPrimes = new ArrayList<>();

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void isDivisibleByTwo(int number) {
        while (number % 2 == 0) {
            getPrimes.add(2);
            number /= 2;
        }
    }

    public static void isDivisibleByOddNumbers(int number) {
        for (int i = 3; i <= number; i += 2) {
            while (number % i == 0) {
                getPrimes.add(i);
                number /= i;
            }
        }
    }

    public static void isGreaterThanTwoPrime(int number) {
        if (number > 2 && isPrime(number)) {
            getPrimes.add(number);
        }
    }

    public static List<Integer> primes (int number){
        isDivisibleByTwo(number);
        isDivisibleByOddNumbers(number);
        isGreaterThanTwoPrime(number);
        return getPrimes;
    }

    public static void clearPrimeList() {
        getPrimes.clear();
    }
}


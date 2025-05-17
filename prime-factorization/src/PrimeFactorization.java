import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static void main(String[] args) {
        System.out.println(printPrimes(100));
    }

    public static List<Integer> primes = new ArrayList<>();

    public static void addPrimesToList(int number) {
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                primes.add(i);
                number /= i;
            }
        }
    }

    public static void addRemainingPrimeToList(int number) {
        int originalNumber = number;
        if (number > 2 && number != originalNumber) {
            primes.add(number);
        }
    }

    public static List<Integer> printPrimes(int number) {
        addPrimesToList(number);
        addRemainingPrimeToList(number);
        return primes;
    }

    public static void clearPrimeList() {
        primes.clear();
    }
}


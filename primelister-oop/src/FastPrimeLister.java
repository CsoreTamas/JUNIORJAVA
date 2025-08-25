import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastPrimeLister implements PrimeLister {
    static int max = 1_000_000;
    static boolean[] sieve = new boolean[max + 1];
    static List<Integer> primesUpToIntegerMax = new ArrayList<>();

    static {
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (sieve[i]) { // i stays true
                //All multiples of 'i' are marked as false (not prime).
                for (int j = i * i; j <= max; j += i) {
                    sieve[j] = false;
                }
            }
        }
        //than we can fill the List with the true indexes until max.
        for (int i = 2; i <= max; i++) {
            if (sieve[i]) {
                primesUpToIntegerMax.add(i);
            }
        }
    }


    @Override
    public List<Integer> generatePrimes(int number) {
        if (sieve.length <= number) {
            System.err.println("Oops!");
        }
        List<Integer> primes = new ArrayList<>();

        //than we go until number.
        for (int prime : primesUpToIntegerMax) {
            if (prime > number) {
                break;
            }
            primes.add(prime);
        }
        return primes;
    }
}

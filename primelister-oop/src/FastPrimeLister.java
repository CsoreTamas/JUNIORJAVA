import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastPrimeLister implements PrimeLister {
    static boolean[] sieve = new boolean[Integer.MAX_VALUE];

    @Override
    public List<Integer> generatePrimes(int number) {
        if (sieve.length <= number) {
            System.err.println("Oops!");
        }
        List<Integer> primes = new ArrayList<>();
        sieve[0] = false;
        sieve[1] = false;
        Arrays.fill(sieve, true);

        for (int i = 2; i * i <= number; i++) {
            if (sieve[i]) { // i stays true
                //All multiples of 'i' are marked as false (not prime).
                for (int j = i * i; j <= number; j += i) {
                    sieve[j] = false;
                }
            }
        }
        //than we can fill the List with the true indexes.
        for (int i = 2; i <= number; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}

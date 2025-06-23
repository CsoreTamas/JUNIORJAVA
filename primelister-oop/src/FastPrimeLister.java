import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastPrimeLister implements PrimeLister {
    @Override
    public List<Integer> generatePrimes(int number) {
        List<Integer> primes = new ArrayList<>();
        //create a boolean array up to number
        boolean[] prime = new boolean[number + 1];
        //fill with true.
        Arrays.fill(prime, true);
        //the first two element are false cause 0 and 1 is not prime.
        prime[0] = false;
        prime[1] = false;


        for (int i = 2; i * i <= number; i++) {
            if (prime[i]) { // i stays true
                //All multiples of 'i' are marked as false (not prime).
                for (int j = i * i; j <= number; j += i) {
                    prime[j] = false;
                }
            }
        }
        //than we can fill the List with the true indexes.
        for (int i = 2; i <= number; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}

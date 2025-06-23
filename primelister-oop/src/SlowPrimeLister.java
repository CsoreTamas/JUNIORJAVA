import java.util.ArrayList;
import java.util.List;

public class SlowPrimeLister implements PrimeLister {

    @Override
    public List<Integer> generatePrimes(int number) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (PrimeUtils.isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}

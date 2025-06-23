import java.util.ArrayList;
import java.util.List;

public class MediumPrimeLister implements PrimeLister {
    @Override
    public List<Integer> generatePrimes(int number) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (PrimeUtils.sqrtIsPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}

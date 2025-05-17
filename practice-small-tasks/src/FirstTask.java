
public class FirstTask {
    public static void main(String[] args) {
        int primeCounter = 0;

        for (int i = 1000; i < 2073; ++i) {
            if (isPrime(i)) {
                System.out.println(i);
                primeCounter++;
            }
        }
        System.out.println(primeCounter);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for (int i = 2; (double) i <= Math.sqrt((double) number); ++i) {
                if (number % 2 == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}

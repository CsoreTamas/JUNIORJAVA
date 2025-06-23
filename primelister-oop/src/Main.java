public class Main {
    public static void main(String[] args) {
        PrimeLister slowPrimeLister = new SlowPrimeLister();
        System.out.println(slowPrimeLister.generatePrimes(1200));

        PrimeLister mediumPrimeLister = new MediumPrimeLister();
        System.out.println(mediumPrimeLister.generatePrimes(1200));

        PrimeLister fastPrimeLister = new FastPrimeLister();
        System.out.println(fastPrimeLister.generatePrimes(1200));
    }
}
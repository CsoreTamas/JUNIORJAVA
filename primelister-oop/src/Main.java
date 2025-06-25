//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
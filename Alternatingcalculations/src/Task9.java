public class Task9 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 4, 9, 6, 3, 8};

        int evenNumberCount = 0;
        int oddNumberCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumberCount++;
            } else {
                oddNumberCount++;
            }
        }
        System.out.println(evenNumberCount);
        System.out.println(oddNumberCount);
    }
}

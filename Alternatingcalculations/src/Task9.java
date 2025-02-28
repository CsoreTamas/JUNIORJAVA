public class Task9 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 4, 9, 6, 3, 8};

        int evenNumbers = 0;
        int oddNumbers = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers++;
            } else {
                oddNumbers++;
            }
        }
        System.out.println(evenNumbers);
        System.out.println(oddNumbers);
    }
}

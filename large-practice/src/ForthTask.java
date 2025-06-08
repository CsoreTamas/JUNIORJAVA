import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForthTask {
    public static void main(String[] args) {
        int number = getUserInput();
        List<Integer> collatzList = calculateCollatz(number);
        System.out.println(collatzList);
        easterEgg(collatzList);
        List<Integer> list = makeCollatzSizeMultiplyByTwoList(collatzList);
        System.out.println(list);
        isGreaterThan(list);
        System.out.println("Thanks for being here! Goodbye.");
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number between 3 - 12.500: ");

        int number;
        for (number = scanner.nextInt(); !isValid(number); number = scanner.nextInt()) {
            System.out.println("Please enter a number again: ");
        }

        return number;
    }

    public static boolean isValid(int number) {
        return number >= 3 && number <= 12500;
    }

    public static List<Integer> calculateCollatz(int number) {
        List<Integer> collatz = new ArrayList<>();
        while (number != 1) {
            collatz.add(number);
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
        }
        collatz.add(1);
        return collatz;
    }

    public static void easterEgg(List<Integer> list) {
        int result = 1;

        for (Integer integer : list) {
            result *= integer;
        }

        if (result == 5120) {
            System.out.println("You won a big nothing, but you find a easter egg.");
        }

    }

    public static List<Integer> makeCollatzSizeMultiplyByTwoList(List<Integer> list) {
        List<Integer> arrayList = new ArrayList<>();
        int number = list.size();

        for (int i = 0; i < 10; ++i) {
            arrayList.add(number);
            number *= 2;
        }

        return arrayList;
    }

    public static void isGreaterThan(List<Integer> list) {
        if (list.getLast() > 10000) {
            System.out.println("Your last number is greater than 10_000!");
        }
    }
}


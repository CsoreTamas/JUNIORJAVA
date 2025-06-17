import java.util.ArrayList;
import java.util.List;

public class RecemansSequenceRecursive {
    public static void main(String[] args) {
        System.out.println(calculateRecemansSequenceRecursively(10));
    }

    public static List<Integer> calculateRecemansSequenceRecursively(int number) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        helper(number, 1, 0, result);
        return result;
    }

    private static void helper(int number, int index, int previous, List<Integer> result) {
        if (index >= number) {
            return;
        }
        int actualNumber = previous - index;
        if (actualNumber <= 0 || result.contains(actualNumber)) {
            actualNumber = previous + index;
        }
        result.add(actualNumber);
        helper(number, index + 1, actualNumber, result);
    }
}

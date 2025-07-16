//write a method that takes in a List of numbers and
//returns whether there are duplicate numbers in that list

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FifthTask {
    public static boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }
}

//write a method that takes in two lists and
//returns with 1 if the first list contains more unique elements
//returns with 2 if the second list contains more unique elements
//returns with 0 if they contain the exact amount of unique elements

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SixthTask {
    public static int elementComparator(List<Integer> firtsList, List<Integer> secondList) {
        Set<Integer> firstListSet = new HashSet<>(firtsList);
        Set<Integer> secondListSet = new HashSet<>(secondList);

        if (firstListSet.size() > secondListSet.size()) {
            return 1;
        } else if (secondListSet.size() > firstListSet.size()) {
            return 2;
        }
        return 0;
    }
}

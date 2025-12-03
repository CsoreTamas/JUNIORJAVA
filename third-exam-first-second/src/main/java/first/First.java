package first;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class First {
    public static List<Integer> removeDuplicates(List<Integer> inputList) {
        Set<Integer> removedDuplicates = new LinkedHashSet<>(inputList);
        return new ArrayList<>(removedDuplicates);
    }
}

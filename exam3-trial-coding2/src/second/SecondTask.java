package second;

import java.util.ArrayList;
import java.util.List;

public class SecondTask {
    public static List<Integer> mergeLists(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> resultList = new ArrayList<>();
        int size = Math.max(firstList.size(), secondList.size());

        for (int i = 0; i < size; i++) {
            if (i < firstList.size()) {
                resultList.add(firstList.get(i));
            }
            if (i < secondList.size()) {
                resultList.add(secondList.get(i));
            }
        }
        return resultList;
    }
}

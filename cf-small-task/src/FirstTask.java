import java.util.ArrayList;
import java.util.List;
//write a method that takes in two lists and
//returns with a third one with the intersection of the two lists

public class FirstTask {
    public static List<Integer> getIntersection(List<Integer> first, List<Integer> second) {
        List<Integer> resultList = new ArrayList<>(first);
        resultList.retainAll(second);
        return resultList;
    }
}

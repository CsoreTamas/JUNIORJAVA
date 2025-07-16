import java.util.ArrayList;
import java.util.List;
//create a method that takes a list of words
//and returns a new list with the words reversed.

public class SecondTask {
    public static List<String> getReversedList(List<String> words) {
        List<String> reversedList = new ArrayList<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            reversedList.add(sb.reverse().toString());
        }
        return reversedList;
    }
}

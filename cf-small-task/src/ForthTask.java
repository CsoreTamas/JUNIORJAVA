import java.util.HashMap;
import java.util.Map;
//write a method that takes in a String and returns
//the number of unique characters in that string

public class ForthTask {
    public static int countUniqueChars(String word) {
        Map<Character, Integer> characters = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            char actualCh = word.charAt(i);
            if (!characters.containsKey(actualCh)) {
                characters.put(word.charAt(i), 1);
                counter++;
            } else {
                characters.put(actualCh, characters.get(actualCh) + 1);
                counter--;
            }
        }
        return counter;
    }
}

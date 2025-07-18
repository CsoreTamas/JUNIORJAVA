import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//write a method that takes in a String and returns
//the number of unique characters in that string

public class ForthTask {
    public static int countUniqueChars(String word) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            characters.add(word.charAt(i));
        }
        return characters.size();
    }
}

package constaint.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConstraintBasedWindow {
    public static String getSmallestSubString(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("String can't be empty");
        }
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            uniqueChars.add(string.charAt(i));
        }

        Map<Character, Integer> chars = new HashMap<>();
        int start = 0;
        int actualStart = 0;
        int charCounter = 0;
        int minLength = Integer.MAX_VALUE;

        for (int end = 0; end < string.length(); end++) {
            char chKey = string.charAt(end);
            chars.merge(chKey, 1, Integer::sum);
            if (chars.get(chKey) == 1) {
                charCounter++;
            }

            while (uniqueChars.size() == charCounter) {
                int length = end - actualStart + 1;

                if (length < minLength) {
                    minLength = length;
                    start = actualStart;
                }

                char startChar = string.charAt(actualStart);
                chars.put(startChar, chars.get(startChar) - 1);
                if (chars.get(startChar) == 0) {
                    charCounter--;
                }
                actualStart++;
            }
        }
        return string.substring(start, start + minLength);
    }
}

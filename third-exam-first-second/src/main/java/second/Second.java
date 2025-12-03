package second;

import java.util.HashMap;
import java.util.Map;

public class Second {
    public static char searchMajorityElement(String input) {
        Map<Character, Integer> counterMap = new HashMap<>();
        int n = input.length();

        for (char ch : input.toCharArray()) {
            //counterMap.put(ch, counterMap.getOrDefault(ch, 0) + 1);
            if (counterMap.containsKey(ch)) {
                counterMap.put(ch, counterMap.get(ch) + 1);
            } else {
                counterMap.put(ch, 1);
            }
            if (counterMap.get(ch) > n / 2) {
                return ch;
            }
        }
        throw new NoMajorityException("No majority element");
    }
}

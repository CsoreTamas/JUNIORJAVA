import java.util.*;

public class AlgorithmicTasks {
    //15.
    //Given a string, find the length of the smallest substring that contains all the
    //unique characters from the original string.
    //Input: "aabcbcdbca" Output: 4 Explanation:
    // The smallest substring containing all unique characters is "dbca"
    public static int getSmallestSubstring(String text) {
        Set<Character> uniqueChars = new LinkedHashSet<>();
        for (int i = 0; i < text.length(); i++) {
            uniqueChars.add(text.charAt(i));
        }
        return uniqueChars.size();
    }

    //16.
    //Given a string, return the first non-repeating character.
    //Input: "aabbcdeff"
    //Output: "c"
    public static char getFirstUniqueChar(String string) {
        Map<Character, Integer> chars = new LinkedHashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (chars.containsKey(string.charAt(i))) {
                chars.put(string.charAt(i), string.charAt(i) + 1);
            } else {
                chars.put(string.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> frequency : chars.entrySet()) {
            if (frequency.getValue() == 1) {
                return frequency.getKey();
            }
        }
        return ' ';
    }

    //17.
    //Given a list of words, group them into lists of anagrams.
//Input: ["act", "cat", "dog", "god", "tac"]
//Output: [[act, cat, tac], [dog, god]]
    public static List<Set<String>> getAnagramsGroups(List<String> words) {
        Map<String, Set<String>> groupedWord = new HashMap<>();
        for (String word : words) {
            char[] characters = word.toCharArray();
            Arrays.sort(characters);
            String key = new String(characters);
            if (groupedWord.containsKey(key)) {
                Set<String> currentWord = groupedWord.get(key);
                currentWord.add(word);
            } else {
                Set<String> values = new TreeSet<>();
                values.add(word);
                groupedWord.put(key, values);
            }
        }
        List<Set<String>> groupedWordList = new ArrayList<>();
        for (Map.Entry<String, Set<String>> groupedWordEntry : groupedWord.entrySet()) {
            groupedWordList.add(groupedWordEntry.getValue());
        }
        return groupedWordList;
    }

    //18
    //Find the most frequent word in a list of strings.
    //Input: ["apple", "banana", "apple", "orange", "banana", "apple"]
    //Output: "apple"
    public static String getMostFrequentWord(List<String> words) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }
        String word = "";
        int counter = 0;
        for (Map.Entry<String, Integer> frequencies : frequency.entrySet()) {
            if (frequencies.getValue() > counter) {
                counter = frequencies.getValue();
                word = frequencies.getKey();
            }
        }
        return word;
    }

    //19
    //Return the list of duplicated elements in an array.
    //Input: [1, 2, 3, 2, 4, 1, 5]
    //Output: [1, 2]
    public static List<Integer> getDuplicateNumbers(int[] array) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int number : array) {
            if (frequency.containsKey(number)) {
                frequency.put(number, number + 1);
            } else {
                frequency.put(number, 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> frequencies : frequency.entrySet()) {
            if (frequencies.getValue() > 1) {
                resultList.add(frequencies.getKey());
            }
        }
        return resultList;
    }

    //20.
    //Given two arrays, check if they contain the same elements
    //with the same frequencies.
    //Input: [1, 2, 2, 3], [2, 1, 3, 2]
    //Output: true
    public static boolean searchDuplicatesFirst(int[] firstArray, int[] secondArray) {
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = i + 1; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchDuplicates(int[] firstArray, int[] secondArray) {
        Set<Integer> nemtom = new HashSet<>(firstArray.length);
        for (int number : secondArray) {
            if (!nemtom.add(number)) {
                return true;
            }
        }
        return false;
    }

    //21.
    //Find the minimum number of character changes to make
    //all characters in the string the same.
    //Input: "aabbc"
    //Output: 3 (change 2 b’s and 1 c to a)
    public static int countMinNumbersChanges(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char actual = text.charAt(i);
            if (frequencies.containsKey(actual)) {
                frequencies.put(actual, frequencies.get(actual) + 1);
            } else {
                frequencies.put(actual, 1);
            }
        }

        int mostFrequent = 0;
        for (Map.Entry<Character, Integer> frequency : frequencies.entrySet()) {
            if (frequency.getValue() > mostFrequent) {
                mostFrequent = frequency.getValue();
            }
        }
        return text.length() - mostFrequent;
    }

    //22
    //Return the list of elements that appear exactly once in the array.
    //Input: [1, 2, 2, 3, 4, 4, 5]
    //Output: [1, 3, 5]
    public static List<Integer> searchUniqueElement(int[] array) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int number : array) {
            if (frequency.containsKey(number)) {
                frequency.put(number, frequency.get(number) + 1);
            } else {
                frequency.put(number, 1);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> frequencies : frequency.entrySet()) {
            if (frequencies.getValue() == 1) {
                resultList.add(frequencies.getKey());
            }
        }
        return resultList;
    }

    //23
    //en an array, group numbers by their frequency.
    //Input: [1, 2, 2, 3, 3, 3]
    //Output: {1=[1], 2=[2], 3=[3]}
    public static Map<Integer, List<Integer>> getNumbersFrequency(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : array) {
            if (frequencyMap.containsKey(number)) {
                frequencyMap.put(number, frequencyMap.get(number) + 1);
            } else {
                frequencyMap.put(number, 1);
            }
        }
        Map<Integer, List<Integer>> frequencies = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (frequencies.containsKey(frequency)) {
                frequencies.get(frequency).add(number);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(number);
                frequencies.put(frequency, list);
            }
        }
        return frequencies;
    }

    //24
    //Given a map of String → Integer,
    //create a new map of Integer → List<String> (invert the mapping).
    //Input: {a=1, b=2, c=1}
    //Output: {1=[a, c], 2=[b]}
    public static Map<Integer, List<String>> flipMaps(Map<String, Integer> inputMap) {
        Map<Integer, List<String>> resultMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            String inputKey = entry.getKey();
            int inputValue = entry.getValue();

            if (!resultMap.containsKey(inputValue)) {
                resultMap.put(inputValue, new ArrayList<>());
            }
            resultMap.get(inputValue).add(inputKey);


        }
        return resultMap;
    }
}
import java.util.ArrayList;
import java.util.List;
//write a method that takes a list of words and returns
//a new list containing only the palindromic words.

public class ThirdTask {
    public static List<String> getPalindromes(List<String> words) {
        List<String> palindromes = new ArrayList<>();
        for (String word : words) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    public static boolean isPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString().equals(word);
    }
}

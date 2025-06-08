import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromeTest {
    @Test
    void shouldDecideIsValidWord() {
        Assertions.assertTrue(Palindrome.isValidWord("hell"));
        Assertions.assertTrue(Palindrome.isValidWord("qwertzuiopasdfg"));
    }

    @Test
    void shouldBeNotValid() {
        Assertions.assertFalse(Palindrome.isValidWord("he"));
        Assertions.assertFalse(Palindrome.isValidWord("qwertzuiopasdfgh"));
    }

    @Test
    void shouldBePalindrome() {
        Assertions.assertTrue(Palindrome.isPalindrome("Racecar"));
        Assertions.assertTrue(Palindrome.isPalindrome("maM"));
    }

    @Test
    void shouldBeNotPalindrome() {
        Assertions.assertFalse(Palindrome.isPalindrome("hello"));
        Assertions.assertFalse(Palindrome.isPalindrome("asdasd"));
    }

    @Test
    void shouldBeVowelInTheWord() {
        Assertions.assertTrue(Palindrome.hasVowel("hello"));
        Assertions.assertTrue(Palindrome.hasVowel("kick"));
    }

    @Test
    void shouldNotBeVowelInTheWord() {
        Assertions.assertFalse(Palindrome.hasVowel("qwrts"));
        Assertions.assertFalse(Palindrome.hasVowel("prdtbsgt"));
    }

    @ParameterizedTest
    @ValueSource(
            chars = {'a', 'e', 'i', 'o', 'u'}
    )
    void shouldBeVowel(char c) {
        Assertions.assertTrue(Palindrome.isVowel(c));
    }

    @ParameterizedTest
    @ValueSource(
            chars = {'q', 'w', 'r', 't', 'z', 'p', 's', 'd', 'f', 'g', 'h', 'k', 'l', 'y', 'x', 'c', 'v', 'b', 'n', 'm'}
    )
    void shouldBeNotVowel(char c) {
        Assertions.assertFalse(Palindrome.isVowel(c));
    }

    @Test
    void shouldCountVowelsAndConsonant() {
        int[] array = new int[]{4, 5};
        Assertions.assertArrayEquals(array, Palindrome.countVowelsAndConsonant("aaaakkkkk"));
        int[] testArray = new int[]{0, 10};
        Assertions.assertArrayEquals(testArray, Palindrome.countVowelsAndConsonant("qqqqqqqqqq"));
        int[] testAry = new int[]{10, 0};
        Assertions.assertArrayEquals(testAry, Palindrome.countVowelsAndConsonant("aaaaaaaaaa"));
    }

    @Test
    void shouldCalculateVowelPercentage() {
        int[] characters = new int[]{3, 7};
        Assertions.assertEquals(30, Palindrome.calculateVowelPercent(characters, "aaaqqqqqqq"));
        int[] testArray = new int[]{0, 10};
        Assertions.assertEquals(0, Palindrome.calculateVowelPercent(testArray, "qqqqqqqqqq"));
        int[] testAry = new int[]{10, 0};
        Assertions.assertEquals(100, Palindrome.calculateVowelPercent(testAry, "aaaaaaaaaa"));
    }
}

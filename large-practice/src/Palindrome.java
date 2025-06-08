import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello dear " + name + "!");
        String word = getAValidWord();
        palindromeOrNot(word);
        if (!isPalindrome(word)) {
            int[] counters = countVowelsAndConsonant(word);
            int vowelPercentage = calculateVowelPercent(counters, word);
            System.out.println(vowelPercentage + "% is vowel in your word.");
        }

    }

    public static String getAValidWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a word: ");
        String word = scanner.nextLine();

        for (int counter = 0; counter < 7; word = scanner.nextLine()) {
            if (isValidWord(word)) {
                return word;
            }

            ++counter;
            if (counter <= 5) {
                System.out.print("Please enter a word again : ");
            } else {
                System.out.print("Enter a word between 3-15 character! For example: dog, cat,television : ");
            }
        }

        System.out.println("You couldn't enter a valid word. Have a great day. Goodbye!");
        System.exit(0);
        return "";
    }

    public static boolean isValidWord(String word) {
        return word.length() <= 15 && word.length() >= 3;
    }

    public static boolean isPalindrome(String word) {
        String lowerCaseWord = word.toLowerCase();
        return lowerCaseWord.contentEquals((new StringBuilder(lowerCaseWord)).reverse());
    }

    public static void palindromeOrNot(String word) {
        if (isPalindrome(word)) {
            System.out.println("Your word is a palindrome word!");
            if (word.equals("madam") || word.equals("racecar")) {
                System.out.println("And you find an Easter Egg congrats!");
            }
        }

        if (!isPalindrome(word) && hasVowel(word)) {
            System.out.println("Your word is not a palindrome word! ");
            System.out.println("But contains vowel!");
        }

    }

    public static boolean isVowel(char c) {
        char character = Character.toLowerCase(c);
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }

    public static boolean hasVowel(String word) {
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                return true;
            }
        }

        return false;
    }

    public static int[] countVowelsAndConsonant(String word) {
        int vowelCounter = 0;
        int consonantCounter = 0;

        for (int i = 0; i < word.length(); ++i) {
            if (isVowel(word.charAt(i))) {
                ++vowelCounter;
            } else {
                ++consonantCounter;
            }
        }

        return new int[]{vowelCounter, consonantCounter};
    }

    public static int calculateVowelPercent(int[] characters, String word) {
        characters = countVowelsAndConsonant(word);
        int vowels = characters[0];
        int consonants = characters[1];
        return (int) Math.floor((double) (vowels * 100) / (double) (vowels + consonants));
    }
}

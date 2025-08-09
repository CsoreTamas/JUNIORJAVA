package first.task;

public class FirstTask {
    public static void main(String[] args) {
        String text = formatSentenceByWordLength("the quick brown fox jumps over the lazy dog");
        System.out.println(text);
    }

    public static String formatSentenceByWordLength(String text) {
        StringBuilder sb = new StringBuilder();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 3) {
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
                sb.append(words[i]);
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}


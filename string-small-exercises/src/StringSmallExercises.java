public class StringSmallExercises {
    public static void main(String[] args) {
    }

    //returns the occurrence of the 'B' character. For example:
    //”bBffFDGddbB” → should return 2
    //”abc” → should return 0
    public static int countTheBOccurrenceInString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        int counter = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == 'B') {
                counter++;
            }
        }
        return counter;
    }

    //returns how many times “hello” is repeated in that String.
    // Check how the substring method works to solve this exercise. For example:
    //”lovely string” → should return 0
    //”helloabcdhelloasvbhellogdvmhello” ->should return 4
    public static int countHelloInAString(String string) {
        int count = 0;
        int index = 0;
        while (index <= string.length() - 5) {
            if (string.substring(index, index + 5).equals("hello")) {
                count++;
                index += 5;
            }
            index++;
        }
        return count;
    }
}
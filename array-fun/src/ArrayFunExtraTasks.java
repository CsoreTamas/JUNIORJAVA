public class ArrayFunExtraTasks {
    public static int getTheNumberOfPalindromesStrings(String[][][] array) {
        int numberOfPalindromes = 0;
        for (String[][] subText : array) {
            for (String[] subText1 : subText) {
                for (String subText2 : subText1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (subText2 == stringBuilder.reverse(subText2)) {
                        numberOfPalindromes++;
                    }
                }
            }
        }
        return numberOfPalindromes;

    }

 //   public static int[] getTheSubSubArrayStrings(String[][][] array) {

   // }

    public static String concantenateAllString(String[][][] array){
        String string
    }

    public static void main(String[] args) {
        String[][][] testArray = {
                {
                        {"Hello", "olo", "asddsa"},
                        {"racecar", "tablet", "vase"},
                        {"ere", "xcx", "good by"}
                }
        };
        System.out.println(getTheNumberOfPalindromesStrings(testArray));
    }
}

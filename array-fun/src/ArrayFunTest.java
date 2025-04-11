import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayFunTest {

    @Test
    void shouldCalculateAverageOfEvenNumbers() {
        int[] testArray = {3, 2, 4, 5, 6, 7, 8, 10, -4, 0, 16};
        Assertions.assertEquals(6, ArrayFun.getTheAverageOfEvenNumbers(testArray));
    }

    @Test
    void shouldFillWithOddNumbersInSquare() {
        int[] testArray = {2, 3, 4, 5, 6, 7, 8, 9, 0, -2, -3, -4, -5};
        int[] expectedArray = {9, 25, 49, 81, 9, 25};
        Assertions.assertArrayEquals(expectedArray, ArrayFun.getTheOddNumbersSquare(testArray));
    }

    @Test
    void shouldGetTheNumbersOfStrings() {
        String[] testArray = {"Hello", "Apple", "Anaconda", "append", "dog", "people"};
        Assertions.assertEquals(3, ArrayFun.getTheNumberOfStringsWhichStartsWithAOra(testArray));
    }

    @Test
    void shouldConcatenateTheStrings() {
        String[] strTestArray = {"Have a", "per", " good day", "Ho", "An", " dear", "end", "dog", " teacher", "! :)"};
        String result = "Have a good day dear teacher! :)";
        Assertions.assertEquals(result, ArrayFun.concatenateAllStringWhichLongerThan3Char(strTestArray));
    }

    @Test
    void shouldReturnTrue() {
        int[] testArray = {2, 1, 3, 4, 3, 5, 3, 1, 0, 1, 1, 2, 3};
        Assertions.assertTrue(ArrayFun.searchAnyDuplication(testArray));
    }

    @Test
    void shouldReturnFalse() {
        int[] testArray = {2, 1, 3, 4, 3, 5, 3, 1, 0, 1, 2, 3};
        Assertions.assertFalse(ArrayFun.searchAnyDuplication(testArray));
    }

    @Test
    void shouldCountTheVowels() {
        String[][] testArray = {
                {"Hello", "Dog", "Cat"},
                {"table", "TV", "char"},
                {"apply", "pear", "peach"}
        };
        Assertions.assertEquals(12, ArrayFun.countTheVowels(testArray));
    }

    @Test
    void shouldCalculateTheLongestStringsLengthAdditions() {
        String[][] testArray = {
                {"Hello", "Dog", "Cat"},
                {"table", "TV", "char"},
                {"apply", "pear", "friend"}
        };
        Assertions.assertEquals(16, ArrayFun.calculateTheSumOfTheLengthsOfTheLongestStrings(testArray));
    }

    @Test
    void shouldGetAn1dArrayWithUppercase() {
        String[][] testArray = {
                {"Hello", "Dog", "Cat"},
                {"table", "TV", "char"},
                {"apply", "pear", "friend"}
        };
        String[] expected = {"HELLO", "DOG", "CAT", "TABLE", "TV", "CHAR", "APPLY", "PEAR", "FRIEND"};
        Assertions.assertArrayEquals(expected,ArrayFun.getTheAllStringsInUppercase(testArray));
    }

    @Test
    void shouldReturnTheCorrectBooleanValue(){
        String[][] testArray = {
                {"Hel2lo", "Dog", "Ca5t"},
                {"tabl3e", "TV", "char"},
                {"app1ly", "pear", "pe3acha"}
        };
        boolean[][] expectedArray = {
                {true,false,true},
                {true, false, false},
                {true, false, true}
        };
        Assertions.assertArrayEquals(expectedArray,ArrayFun.searchAnyNumberInTheStrings(testArray));
    }

    @Test
    void shouldGetTheStringsLengthAverage(){
        String[][] testArray = {
                {"Hello", "Doges", "Casts"},
                {"table", "mouses", "chars"},
                {"apply", "pear", "peach"}
        };
        Assertions.assertEquals(5.0,ArrayFun.calculateAverageOfStrings(testArray));
    }
}

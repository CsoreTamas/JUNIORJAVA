import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayFunExtraTasks3DTest {
    @Test
    void shouldCountThePalindromesInTheArray() {
        String[][][] testArray = {
                {
                        {"apples", "banana"},
                        {"qweewq", "dog", "elephant"},
                        {"tables"}
                },
                {
                        {"fishs"},
                        {"goat", "ses"},
                        {"asa", "goats"}
                }
        };
        Assertions.assertEquals(3, ArrayFunExtraTasks3D.getTheNumberOfPalindromesStrings(testArray));
    }

    @Test
    void shouldCountIfItsPalindromes(){
        String string = "racecar";
        Assertions.assertEquals(1, ArrayFunExtraTasks3D.counter(string));
        String str = "temple";
        Assertions.assertEquals(0,ArrayFunExtraTasks3D.counter(str));
    }

    @Test
    void shouldCountTheSubSubArrayStrings() {
        String[][][] testArray = {
                {
                        {"apples", "banana"},
                        {"qweewq", "dog", "elephant"},
                        {"tables"}
                },
                {
                        {"fishs"},
                        {"goat", "ses"},
                        {"asa", "goats"}
                }
        };
        int[] expected = {2, 3, 1, 1, 2, 2};
        Assertions.assertArrayEquals(expected, ArrayFunExtraTasks3D.countStringsInSubSubArray(testArray));
    }

    @Test
    void shouldCountTheElementsOfAnArray() {
        String[][][] testArray = {
                {
                        {"apples", "banana"},
                        {"qweewq", "dog", "elephant"},
                        {"tables"}
                },
                {
                        {"fishs"},
                        {"goat", "ses"},
                        {"asa", "goats"}
                }
        };
        int[] expected = {0, 0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, ArrayFunExtraTasks3D.countElements(testArray));
    }

    @Test
    void shouldConcatenateAllStringsLongerThan2() {
        String[][][] testArray = {
                {
                        {"apples", "ba"},
                        {"qw", "dog", "e"},
                        {"t"}
                },
                {
                        {"f"},
                        {"g", "se"},
                        {"a", "goats"}
                }
        };
        Assertions.assertEquals("applesdoggoats", ArrayFunExtraTasks3D.concatenateAllStringWitchLongerThan2(testArray));
    }

    @Test
    void shouldGetTheLongestStringLength() {
        String[][][] testArray = {
                {
                        {"apples", "banana"},
                        {"qweewq", "dog", "elephant"},
                        {"tables"}
                },
                {
                        {"fishs"},
                        {"goat", "ses"},
                        {"asa", "goats"}
                }
        };
        Assertions.assertEquals(8, ArrayFunExtraTasks3D.getTheLongestStringLength(testArray));
    }

    @Test
    void haSShouldReturnTrue() {
        String[][][] testArray = {
                {
                        {"apples", "banana"},
                        {"qweewq", "dog", "elephants"},
                        {"tables"}
                },
                {
                        {"fishs"},
                        {"goat", "ses"},
                        {"asas", "goats"}
                }
        };
        Assertions.assertTrue(ArrayFunExtraTasks3D.searchAnySAtThe3rdArray(testArray));
    }

    @Test
    void notHasSShouldReturnFalse() {
        String[][][] testArray = {
                {
                        {"apple", "banana"},
                        {"qweewq", "dog", "elephant"},
                        {"tables"}
                },
                {
                        {"fishs"},
                        {"goat", "ses"},
                        {"asa", "goats"}
                }
        };
    Assertions.assertFalse(ArrayFunExtraTasks3D.searchAnySAtThe3rdArray(testArray));
    }
}

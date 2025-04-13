import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class ArrayFunExtraTasks4DTest {
    @Test
    void shouldCountStringsWithLowercase() {

        String[][][][] testArray = {
                {
                        {
                                {"one", "two"},
                                {"three", "Table"}
                        },
                        {
                                {"four", "chaR"},
                                {"five", "six"}
                        }
                },
                {
                        {
                                {"seven", "winDow"},
                                {"Mac", "PIG"}
                        },
                        {
                                {"DOoR", "eight"},
                                {"nine", "ten"}
                        }
                }
        };
        Assertions.assertEquals(10, ArrayFunExtraTasks4D.countLowercaseStrings(testArray));
    }

    @Test
    void shouldReverseAllString() {
        String[][][][] testArray = {
                {
                        {
                                {"one", "two"},
                                {"three", "Table"}
                        },
                        {
                                {"four", "chaR"},
                                {"five", "six"}
                        }
                },
                {
                        {
                                {"seven", "winDow"},
                                {"Mac", "PIG"}
                        },
                        {
                                {"DOoR", "eight"},
                                {"nine", "ten"}
                        }
                }
        };
        String[][][][] expected = {
                {
                        {
                                {"eno", "owt"},
                                {"eerht", "elbaT"}
                        },
                        {
                                {"ruof", "Rahc"},
                                {"evif", "xis"}
                        }
                },
                {
                        {
                                {"neves", "woDniw"},
                                {"caM", "GIP"}
                        },
                        {
                                {"RoOD", "thgie"},
                                {"enin", "net"}
                        }
                }
        };
        Assertions.assertArrayEquals(expected, ArrayFunExtraTasks4D.reverseAllStringInTheArray(testArray));
    }

    @Test
    void shouldGetTheStringLengthAverageRoundedDown() {
        String[][][][] testArray = {
                {
                        {
                                {"12345", "67890"},
                                {"12345", "67890"}
                        },
                        {
                                {"12345", "67890"},
                                {"12345", "67890"}
                        }
                },
                {
                        {
                                {"12345", "67890"},
                                {"12345", "67890"}
                        },
                        {
                                {"1234567890", "1234567890"},
                                {"0123456789", "12345"}
                        }
                }
        };
        //95/16 = 5.9375
        Assertions.assertEquals(5, ArrayFunExtraTasks4D.calculateTheAverageOfStrings(testArray));
    }

    @Test
    void shouldSelectStringsWithMoreThanTwoVowels() {
        String[][][][] testArray = {
                {
                        {
                                {"one", "two"},
                                {"threee", "table"}
                        },
                        {
                                {"fouur", "char"},
                                {"five", "six"}
                        }
                },
                {
                        {
                                {"seven", "winDow"},
                                {"mac", "pig"}
                        },
                        {
                                {"dooor", "eight"},
                                {"ninee", "ten"}
                        }
                }
        };
        List<String> expected = Arrays.asList("threee", "fouur", "dooor", "ninee");
        Assertions.assertEquals(expected, ArrayFunExtraTasks4D.searchStringsWithMoreThanTwoVowels(testArray));
    }

    @Test
    void shouldGetFoundTheShortestString() {
        String[][][][] testArray = {
                {
                        {
                                {"one", "two"},
                                {"three", "Table"}
                        },
                        {
                                {"four", "chaR"},
                                {"five", "six"}
                        }
                },
                {
                        {
                                {"seven", "winDow"},
                                {"Mac", "hi"}
                        },
                        {
                                {"DOoR", "eight"},
                                {"nine", "ten"}
                        }
                }
        };
        Assertions.assertEquals("hi", ArrayFunExtraTasks4D.getTheShortestString(testArray));
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayFunExtraTasks5DTest {
    @Test
    void shouldCountTheStrings() {
        String[][][][][] testArray = {
                {
                        {
                                {
                                        {"one", "two"},
                                        {"char", "car"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"error", "factor"},
                                        {"get", "hello"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"is", "window"},
                                        {"BED", "TV"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"bad", "Pillow"},
                                        {"telephone", "stock"}
                                }
                        }
                }
        };
        Assertions.assertEquals(7, ArrayFunExtraTasks5D.countTheStringsWhichNotHaveEOrR(testArray));
    }

    @Test
    void shouldFillTheArrayWithTheStringsLength() {
        String[][][][][] testArray = {
                {
                        {
                                {
                                        {"one", "two"},
                                        {"char", "car"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"error", "factor"},
                                        {"get", "hello"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"is", "window"},
                                        {"BED", "TV"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"bad", "Pillow"},
                                        {"telephone", "stock"}
                                }
                        }
                }
        };
        int [][][][][] expected = {
                {
                        {
                                {
                                        {3, 3},
                                        {4, 3}
                                }
                        }
                },
                {
                        {
                                {
                                        {5, 6},
                                        {3, 5}
                                }
                        }
                },
                {
                        {
                                {
                                        {2, 6},
                                        {3, 2}
                                }
                        }
                },
                {
                        {
                                {
                                        {3, 6},
                                        {9, 5}
                                }
                        }
                }
        };
        Assertions.assertArrayEquals(expected,ArrayFunExtraTasks5D.fillTheArrayWithStringsLength(testArray));
    }

    @Test
    void shouldCalculateTotalLengthWierdStrings (){
        String[][][][][] testArray = {
                {
                        {
                                {
                                        {"one", "two"},
                                        {"char", "car"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"error", "factor"},
                                        {"get", "hello"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"is", "window"},
                                        {"BED", "TV"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"bad", "Pillow"},
                                        {"telephone", "RaceCaR"}
                                }
                        }
                }
        };
        Assertions.assertEquals(13, ArrayFunExtraTasks5D.calculateTotalLengthOfStringsWithSameStartAndEndLetter(testArray));
    }

    @Test
    void shouldConcatenateStrings(){
        String[][][][][] testArray = {
                {
                        {
                                {
                                        {"one", "two"},
                                        {"char", "car"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"error", "factor"},
                                        {"get", "hello"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"is", "window"},
                                        {"BED", "TV"}
                                }
                        }
                },
                {
                        {
                                {
                                        {"bad", "Pillow"},
                                        {"telephone", "stock"}
                                }
                        }
                }
        };
        Assertions.assertEquals("onetwocharcarerrorfactorgethelloiswindowBEDTVbadPillowtelephonestock",ArrayFunExtraTasks5D.concatenateAllStringsTogether(testArray));
    }
}
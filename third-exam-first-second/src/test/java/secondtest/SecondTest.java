package secondtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import second.NoMajorityException;
import second.Second;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondTest {
    @ParameterizedTest
    @CsvSource({
            "aaaab, a",
            "bbbbb, b",
            "bbbaa, a"
    })
    void shouldReturnMajority(String input, char expected) {
        char result = Second.searchMajorityElement(input);
        assertEquals(expected, result);
    }

    @Test
    void shouldThrowNoMajorityException() {
        assertThrows(NoMajorityException.class,
                () -> Second.searchMajorityElement("aabbcc"));

        assertThrows(NoMajorityException.class,
                () -> Second.searchMajorityElement(""));
    }
}


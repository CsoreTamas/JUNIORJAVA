package first.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTaskTest {
    @Test
    void shouldFormatSentenceByWordLength() {
        String text = "the quick brown fox jumps over the lazy dog";
        Assertions.assertEquals("the Quick Brown fox Jumps Over the Lazy dog", FirstTask.formatSentenceByWordLength(text));
    }
}

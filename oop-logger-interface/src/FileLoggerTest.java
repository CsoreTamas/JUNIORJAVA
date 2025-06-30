import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileLoggerTest {
    @Test
    void shouldWriteToFile() throws IOException {
        Logger<String> fileLogger = new FileLogger("src/resources/text-log.txt");
        fileLogger.log("hello every one");

        //Files.readString ---> reads the entire content in ---> Path.of ---> path.
        String text = Files.readString(Path.of("src/resources/text-log.txt"));

        assertTrue(text.contains("hello every one"));
    }
}

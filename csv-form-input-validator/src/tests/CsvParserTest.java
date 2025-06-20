package tests;

import csvparser.CsvParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.User;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvParserTest {
    @Test
    void shouldReadCsvFile() throws IOException {
        Path expected = Path.of("/Users/csoretamas/files/csvparserXXS.csv");
        List<User> expectedList = CsvParser.reader(expected);

        ArrayList<User> result = new ArrayList<>();

        User johnDoe = new User("Invalid name", "john@example.com", "Hello world!");
        result.add(johnDoe);
        User peterParker = new User("Invalid name", "peter@parker.com", "Invalid comment");
        result.add(peterParker);
        User script = new User("Invalid name", "bad@data.com", "Invalid comment");
        result.add(script);
        User alice = new User("alice", "Invalid e-mail", "Just a comment");
        result.add(alice);
        User bob = new User("bob", "bob@example.com", "Invalid comment");
        result.add(bob);

        Assertions.assertEquals(expectedList, result);
    }
}

package tests;

import csvparser.CsvParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usercomment.UserComment;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvParserTest {
    @Test
    void shouldReadCsvFile() throws IOException {
        Path expected = Path.of("/Users/csoretamas/files/csvparserXXS.csv");
        List<UserComment> expectedList = CsvParser.reader(expected);

        ArrayList<UserComment> result = new ArrayList<>();

        UserComment johnDoe = new UserComment("Invalid name", "john@example.com", "Hello world!");
        result.add(johnDoe);
        UserComment peterParker = new UserComment("Invalid name", "peter@parker.com", "Invalid comment");
        result.add(peterParker);
        UserComment script = new UserComment("Invalid name", "bad@data.com", "Invalid comment");
        result.add(script);
        UserComment alice = new UserComment("alice", "Invalid e-mail", "Just a comment");
        result.add(alice);
        UserComment bob = new UserComment("bob", "bob@example.com", "Invalid comment");
        result.add(bob);

        Assertions.assertEquals(expectedList, result);
    }
}

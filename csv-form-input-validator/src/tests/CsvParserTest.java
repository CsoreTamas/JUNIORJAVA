package tests;

import csvparser.CsvParser;
import org.junit.jupiter.api.Test;
import user.UsersComment;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvParserTest {
    @Test
    void shouldReadCsvFile() throws IOException {
        Path expected = Path.of("/Users/csoretamas/files/csvparserXXS.csv");
        List<UsersComment> expectedList = CsvParser.reader(expected);

        List<UsersComment> result = new ArrayList<>();

        UsersComment johnDoe = new UsersComment("Invalid name", "john@example.com", "Hello world!");
        result.add(johnDoe);
        UsersComment peterParker = new UsersComment("Invalid name", "peter@parker.com", "Invalid comment");
        result.add(peterParker);
        UsersComment script = new UsersComment("Invalid name", "bad@data.com", "Invalid comment");
        result.add(script);
        UsersComment alice = new UsersComment("alice", "Invalid e-mail", "Just a comment");
        result.add(alice);
        UsersComment bob = new UsersComment("bob", "bob@example.com", "Invalid comment");
        result.add(bob);

        assertEquals(expectedList, result);
    }
}

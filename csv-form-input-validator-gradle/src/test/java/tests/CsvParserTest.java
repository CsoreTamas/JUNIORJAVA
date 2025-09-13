package tests;

import com.opencsv.exceptions.CsvValidationException;
import org.example.parser.CsvParser;
import org.example.usercomment.UserComment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvParserTest {
    private List<UserComment> userCommentList;

    @BeforeEach
    void readFiles() throws CsvValidationException, IOException {
        userCommentList = CsvParser.reader("/Users/csoretamas/JUNIORJAVAHOMEWORKS/csv-form-input-validator-gradle/src/test/java/tests/test.csv");
    }

    @Test
    void shouldReadFilesOutOfCsvFile() {
        UserComment first = userCommentList.getFirst();
        assertEquals("Invalid name", first.getName());
        assertEquals("john@example.com", first.getEmail());
        assertEquals("Hello world!", first.getComment());

        UserComment second = userCommentList.get(1);
        assertEquals("Invalid name", second.getName());
        assertEquals("peter@parker.com", second.getEmail());
        assertEquals("Invalid comment", second.getComment());

        UserComment third = userCommentList.get(2);
        assertEquals("Invalid name", third.getName());
        assertEquals("bad@data.com", third.getEmail());
        assertEquals("Invalid comment", third.getComment());

        UserComment forth = userCommentList.get(3);
        assertEquals("alice", forth.getName());
        assertEquals("Invalid email", forth.getEmail());
        assertEquals("Just a comment", forth.getComment());
    }

    @Test
    void shouldSkipBadLines() {
        assertEquals(6, userCommentList.size());
    }
}

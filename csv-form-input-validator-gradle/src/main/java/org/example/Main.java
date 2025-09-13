package org.example;

import com.opencsv.exceptions.CsvValidationException;
import org.example.parser.CsvParser;
import org.example.usercomment.UserComment;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CsvValidationException, IOException {
        List<UserComment> commentList = CsvParser.reader("/Users/csoretamas/files/csvparserXXS.csv");
        for (UserComment lines : commentList) {
            System.out.println(lines);
        }
    }
}
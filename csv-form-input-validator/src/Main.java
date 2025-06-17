import csvparser.CsvParser;
import usercomment.UserComment;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<UserComment> userComments = CsvParser.reader(Path.of("/Users/csoretamas/files/csvparserXXS.csv"));
        for (UserComment lines : userComments) {
            System.out.println(lines);
        }
    }
}
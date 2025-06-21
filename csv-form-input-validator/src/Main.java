import csvparser.CsvParser;
import user.UsersComment;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<UsersComment> userComments = CsvParser.reader(Path.of("/Users/csoretamas/files/csvparserXXS.csv"));
        for (UsersComment lines : userComments) {
            System.out.println(lines);
        }
    }
}
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;

public class MeneInputReader {
    private final LineReader lineReader = LineReaderBuilder.builder().build();

    public MemeRequest getInput() {
        long templateId = Long.parseLong(lineReader.readLine("template ID: "));
        String userName = lineReader.readLine("username: ");
        String password = lineReader.readLine("password: ");
        String topText = lineReader.readLine("top text: ");
        String bottomText = lineReader.readLine("bottom text: ");

        return new MemeRequest(templateId, userName, password, topText, bottomText);
    }
}

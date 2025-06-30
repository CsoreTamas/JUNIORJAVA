import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger<String> {
    private final String fileName;

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(message + "\n");
            fileWriter.close();
            System.out.println("Successful write to file: " + message);
        } catch (IOException exception) {
            System.out.println("Failed to write to file!");
        }
    }
}

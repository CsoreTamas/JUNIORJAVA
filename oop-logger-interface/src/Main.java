import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger<String> consoleLogger = new ConsoleLogger();
        consoleLogger.log("hello everyone");

        Logger<String> fileLogger = new FileLogger("src/resources/text-log.txt");
        fileLogger.log("This is the first message to the file.");
    }
}
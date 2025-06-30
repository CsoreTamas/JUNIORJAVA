import java.io.IOException;

public class ConsoleLogger implements Logger<String> {

    @Override
    public void log(String message) throws IOException {
        System.out.println(message);
    }
}

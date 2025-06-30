import java.io.IOException;

public interface Logger<String> {
    void log(String message) throws IOException;
}

import exception.InvalidHandException;
import reader.PropertiesReader;

public class Main {
    public static void main(String[] args) {
        try {
            PropertiesReader.evaluateAndPrintFinalResult();
        } catch (InvalidHandException message) {
            throw new InvalidHandException("Invalid hand");
        }
    }
}
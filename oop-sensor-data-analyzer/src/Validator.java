import java.io.IOException;

public class Validator {
    private final FileLoader fileLoader;

    public Validator(FileLoader fileLoader) throws IOException {
        this.fileLoader = fileLoader;
    }

    public boolean isValid() {
        String format = fileLoader.getExportFormat();
        String fileName = fileLoader.getExportFileName();
        if (fileName.endsWith("." + format)) {
            return true;
        } else {
            throw new RuntimeException("Your file name does not match with the export format");
        }
    }
}

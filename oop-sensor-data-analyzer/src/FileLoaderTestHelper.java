import java.io.IOException;

public class FileLoaderTestHelper extends FileLoader {
    private final String fileName;
    private final String format;

    public FileLoaderTestHelper(String fileName, String format) throws IOException {
        this.fileName = fileName;
        this.format = format;
    }

    @Override
    public String getExportFormat() {
        return format;
    }

    @Override
    public String getExportFileName() {
        return fileName;
    }
}

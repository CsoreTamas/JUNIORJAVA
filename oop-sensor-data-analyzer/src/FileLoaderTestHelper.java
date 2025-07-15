
public class FileLoaderTestHelper implements PropertyLoader {
    private final String fileName;
    private final String format;

    public FileLoaderTestHelper(String fileName, String format) {
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

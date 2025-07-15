import java.io.IOException;

public class ExportFileValidator {
    private final PropertyLoader propertyLoader;

    public ExportFileValidator(PropertyLoader propertyLoader) throws IOException {
        this.propertyLoader = propertyLoader;
    }

    public boolean isValid() {
        String format = propertyLoader.getExportFormat();
        String fileName = propertyLoader.getExportFileName();
        if (fileName.endsWith("." + format)) {
            return true;
        } else {
            throw new InvalidFileFormatException("Your file name does not match with the export format");
        }
    }
}

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoader {
    //Properties object to hold key-value paris loaded from a file.
    private final Properties properties = new Properties();

    //Constructor loads the properties from 'application.properties' file.
    public FileLoader() throws IOException {
        //InputStream --> like a "pipe" that's reads the file content into the program so we can use it.
        //getClass() --> returns the runtime class of this object
        //getClassLoader() --> gets the class loader, that loaded this class
        //getResourceAsStream() --> loads a resource as InputStream from the classpath

        //      getClass()                    getClassLoader                   getResourceAsStream()
        //Witch class i am right now?? / use this class's loader / ask it to find and open the file for reading
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (inputStream == null) {
                throw new IOException("File not foud.");
            } else {
                System.out.println("Successfully write.");
            }
            //.load --> Load the properties from the input stream into the 'properties' object
            properties.load(inputStream);
        }
    }

    //Returns the value of the property 'export.format' from the loaded properties file.
    //for example: "json" / "csv"
    public String getExportFormat() {
        return properties.getProperty("export.format");
    }

    //Returns the value of the property 'export.filename' from the loaded properties file.
    //for example: "jsonData.json" / "csvData.csv"
    public String getExportFileName() {
        return properties.getProperty("export.filename");
    }
}

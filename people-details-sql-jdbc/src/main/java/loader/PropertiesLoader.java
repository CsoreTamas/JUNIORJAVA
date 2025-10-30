package loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private final static String PROP_FILE = "application.properties";
    private final static String URL = "url";
    private final static String USER_NAME = "username";
    private final static String PASSWORD = "password";
    private static PropertiesLoader instance;
    private final Properties properties = new Properties();

    private PropertiesLoader() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROP_FILE)) {
            if (inputStream == null) {
                throw new RuntimeException();
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PropertiesLoader getInstance() {
        if (instance == null) {
            instance = new PropertiesLoader();
        }
        return instance;
    }

    public String getUserName() {
        return properties.getProperty(USER_NAME);
    }

    public String getUrl() {
        return properties.getProperty(URL);
    }

    public String getPassword() {
        return properties.getProperty(PASSWORD);
    }
}

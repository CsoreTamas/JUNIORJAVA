import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class IntegrationTest {
    private final Properties properties = new Properties();
    private final ImgMemeService imgMemeService = new ImgMemeService();

    @Test
    void shouldGenerateMeme() {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String userName = properties.getProperty("imgflip.username");
        String password = properties.getProperty("imgflip.password");

        MemeRequest request = new MemeRequest(
                112126428,
                userName,
                password,
                "top text",
                "bottom text"
        );
        imgMemeService.createMeme(request);
    }
}

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {
    private final ImgMemeService imgMemeService = new ImgMemeService();

    @Test
    void shouldBuildStringEncodedBodyOutOfParams() {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("template_id", "1234");
        params.put("username", "PistaNorbert");
        params.put("password", "pityi32");
        params.put("text0", "I am Pityu");
        params.put("text1", "PITYU");

        String actualEncodedBody = imgMemeService.buildBody(params);

        String expectedEncodedBody = "template_id=1234&username=PistaNorbert&password=pityi32&text0=I+am+Pityu&text1=PITYU";

        assertEquals(expectedEncodedBody, actualEncodedBody);
    }
}

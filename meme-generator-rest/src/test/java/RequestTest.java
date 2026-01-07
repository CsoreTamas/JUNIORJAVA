import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestTest {
    @Test
    public void shouldReturnKeyValuePairs() {
        MemeRequest request = new MemeRequest(
                1234,
                "PistaNorbert",
                "pityu32",
                "I am Pityu",
                "PITYU"
        );

        Map<String, String> params = request.toParams();

        assertEquals("1234", params.get("template_id"));
        assertEquals("PistaNorbert", params.get("username"));
        assertEquals("pityu32", params.get("password"));
        assertEquals("I am Pityu", params.get("text0"));
        assertEquals("PITYU", params.get("text1"));
    }
}

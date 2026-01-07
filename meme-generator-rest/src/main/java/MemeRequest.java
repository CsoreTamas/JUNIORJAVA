import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class MemeRequest {
    private long templateId;
    private String userName;
    private String password;
    private String topText;
    private String bottomText;

    public Map<String, String> toParams() {
        Map<String, String> params = new HashMap<>();
        params.put("template_id", String.valueOf(templateId));
        params.put("username", userName);
        params.put("password", password);
        params.put("text0", topText);
        params.put("text1", bottomText);
        return params;
    }
}

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import tools.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

void main() {
    try {
        HttpClient httpClient = HttpClient.newHttpClient();

        LineReader lineReader = LineReaderBuilder.builder().build();

        long templateId = Long.parseLong(lineReader.readLine("template ID: "));
        String userName = lineReader.readLine("Username: ");
        String password = lineReader.readLine("password: ");
        String topText = lineReader.readLine("top text: ");
        String bottomText = lineReader.readLine("bottom text: ");

        Map<String, String> params = new HashMap<>();
        params.put("template_id", String.valueOf(templateId));
        params.put("username", userName);
        params.put("password", password);
        params.put("text0", topText);
        params.put("text1", bottomText);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!sb.isEmpty()) {
                sb.append("&");
            }

            sb.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
            //(space = +)
            //template_id=11313648&username=xyxy&password=xyxyxy&text0=a+b+c&text1=d
        }

        String body = sb.toString();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.imgflip.com/caption_image")).header("Content-Type", "application/x-www-form-urlencoded").POST(HttpRequest.BodyPublishers.ofString(body)).build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());

        ObjectMapper mapper = new ObjectMapper();
        var formattedJason = mapper.readTree(response.body());
        System.out.println(formattedJason);

    } catch (IOException | InterruptedException e) {
        System.out.println(e.getMessage());
    }
}

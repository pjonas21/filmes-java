import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ImdbApiClient {

    public String clientAPI() throws IOException, InterruptedException {
        Properties apiProps = ApiKeyLoader.loadApiProperties();
        String key = apiProps.getProperty("api.key");

        String endApi = "https://imdb-api.com/en/API/Top250Movies/" + key;
        URI url = null;
        try {
            url = new URI(endApi);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpRequest req = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        String json = resp.body();

        return json;
    }
}

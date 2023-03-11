import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {
    public static void main(String[] args) throws Exception {      

        String endApi = "https://imdb-api.com/en/API/Top250Movies/apiKey";
        URI url = new URI(endApi);

        HttpRequest req = HttpRequest.newBuilder()
            .uri(url)
            .GET()
            .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());

        System.out.println(resp.body());
    }
}

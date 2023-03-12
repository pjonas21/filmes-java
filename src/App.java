import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


// dia 1 - acessar os dados da API e mostrar na linha de comando
// dia 2 - parsear a resposta obtida e extrair o titulo e a URL da imagem de cada filme
// dia 3 - modelar o código de melhor forma, já pensando em Orietação a Objetos
public class App {
    
    public static void main(String[] args) throws Exception {
        String key = "<suaApiKey>";
        String endApi = "https://imdb-api.com/en/API/Top250Movies/" + key;
        URI url = new URI(endApi);

        HttpRequest req = HttpRequest.newBuilder()
            .uri(url)
            .GET()
            .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());
        String json = resp.body();

        ListMovies catalogo = new ListMovies(json);
        catalogo.getFilmes().forEach(System.out::println);

    }
}

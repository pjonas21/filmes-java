import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// dia 1 - acessar os dados da API e mostrar na linha de comando
// dia 2 - parsear a resposta obtida e extrair o titulo e a URL da imagem de cada filme
public class App {
    
    public static void main(String[] args) throws Exception {      
        String key = "k_61y8j4ml";
        String endApi = "https://imdb-api.com/en/API/Top250Movies/" + key;
        URI url = new URI(endApi);

        HttpRequest req = HttpRequest.newBuilder()
            .uri(url)
            .GET()
            .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());
        String json = resp.body();

        String[] moviesArray = parse(json);

        List<String> titles = parseTitles(moviesArray);
        for (String title : titles){
            System.out.println("Titulo: " + title);
        }

        List<String> urlImages = parseUrlImages(moviesArray);
        for (String urlIm : urlImages){
            System.out.println("URL da imagem: " + urlIm);
        }

    }

    private static String[] parse(String json) {
        Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("no match in " + json);
        }

        String[] moviesArray = matcher.group(1).split("\\},\\{");
        moviesArray[0] = moviesArray[0].substring(1);
        //System.out.println(moviesArray[0]);
        int last = moviesArray.length - 1;
        String lastString = moviesArray[last];
        moviesArray[last] = moviesArray[last].substring(0, lastString.length() - 1);
        //System.out.println(moviesArray[last]);
        return moviesArray;
    }

    private static List<String> parseAtrib(String[] moviesArray, int pos){
        return Stream.of(moviesArray)
                .map(e -> e.split("\",\"")[pos])
                .map(e -> e.split(":\"")[1])
                .map(e -> e.replaceAll("\"", ""))
                .collect(Collectors.toList());
    }

    private static List<String> parseTitles(String[] moviesArray){
        return parseAtrib(moviesArray,3);
    }

    private static List<String> parseUrlImages(String[] moviesArray){
        return parseAtrib(moviesArray,5);
    }
}

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;


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

        ListMovies listaFilmes = new ListMovies(json);
        List<Movie> topFilmes = listaFilmes.getFilmes();

        FileWriter writer = new FileWriter("output.html");

        writer.write("<html>");
        writer.write("<head>");
        writer.write("<meta charset=\"utf-8\">");
        writer.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">");
        writer.write("<title>Pagina de filmes</title>");
        writer.write("</head>");
        writer.write("<body>");

        writer.write("<div class=\"container text-center\">");
        writer.write("<h3>Indicacoes de filmes - TOP 250 IMDB</h3>");
        writer.write("<div class=\"row\">");

        for (Movie filme : topFilmes) {
            writer.write("<div class=\"card m-2\" style=\"width: 10rem;\">");
            writer.write("<img src=\"" + filme.getUrlImage() + "\" class=\"card-img-top\" alt=\"...\">");
            writer.write("<div class=\"card-body\">");
            writer.write("<h6 class=\"card-title\">" + filme.getTitle() + "</h6>");
            writer.write("<a href=\"#\" class=\"btn btn-primary\">Nota: " + filme.getRating() +"</a>");
            writer.write("</div>");//card body
            writer.write("</div>");//class card
        }

        writer.write("</div>");//class row
        writer.write("</div>");//class container

        writer.write("</body>");
        writer.write("</html>");

        writer.close();

    }
}

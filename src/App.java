import java.util.List;

// dia 1 - acessar os dados da API e mostrar na linha de comando
// dia 2 - parsear a resposta obtida e extrair o titulo e a URL da imagem de cada filme
// dia 3 - modelar o código de melhor forma, já pensando em Orietação a Objetos
// dia 4 - gerar HTML dos filmes parseados
// dia 5 - encapsular chamada da API e gerador do HTML
public class App {
    
    public static void main(String[] args) throws Exception {

        String json = new ImdbApiClient().clientAPI();

        ListMovies listaFilmes = new ListMovies(json);
        List<Movie> topFilmes = listaFilmes.getFilmes();

        HtmlGenerator.generateHTML(topFilmes);

    }
}


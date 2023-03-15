import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlGenerator {

    public static void generateHTML(List<Movie> movies) throws IOException {

        FileWriter writer = new FileWriter("output.html");

        writer.write("<html>");
        writer.write("<head>");
        writer.write("<meta charset=\"utf-8\">");
        writer.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">");
        writer.write("<title>Página de filmes</title>");
        writer.write("</head>");
        writer.write("<body>");

        writer.write("<div class=\"container text-center\">");
        writer.write("<h3>Recomendação de filmes - TOP 250 IMDB</h3>");
        writer.write("<div class=\"row\">");

        for (Movie filme : movies) {
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

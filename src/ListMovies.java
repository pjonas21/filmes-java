import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListMovies {

    private final List<Movie> movies = new ArrayList<>(250);

    public ListMovies(String json) {
        fillMovies(json);
    }

    private void fillMovies(String json) {
        Matcher m = Pattern.compile("\\{[^{}]*}").matcher(json);
        while (m.find()) {
            String[] information = m.group().split(",\"");
            String title = getValorIsolado(information[2]);
            String urlImage = getValorIsolado(information[4]);
            String year = getValorIsolado(information[5]);
            String rating = getValorIsolado(information[7]);

            movies.add(new Movie(title, urlImage, year, rating));
        }
    }

    public List<Movie> getFilmes() {
        return Collections.unmodifiableList(movies);
    }

    private String getValorIsolado(String s) {
        Matcher m1 = Pattern.compile(":\"([^\"]*)\"").matcher(s);

        if (m1.find()) {
            return m1.group(1);
        }
        return s;
    }
}

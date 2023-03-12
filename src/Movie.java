public class Movie {
    private final String title;
    private final String year;
    private final String urlImage;
    private final String rating;

    public Movie(String title, String year, String urlImage, String rating) {
        this.title = title;
        this.year = year;
        this.urlImage = urlImage;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getRating() {
        return rating;
    }

    public String toString() {
        return "[Titulo: " + title +
                ", Imagem URL: " + urlImage +
                ", Ano: " + year +
                ", Nota: " + rating + "]";
    }
}

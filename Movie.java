public class Movie {
    private String id;
    private String title;
    private String language;
    private String genre;
    private String duration;

    public Movie(String id, String title, String language, String genre, String duration) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.duration = duration;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getLanguage() { return language; }
    public String getGenre() { return genre; }
    public String getDuration() { return duration; }

    @Override
    public String toString() {
        return "[" + language + "] " + title + " (" + genre + ") - " + duration;
    }
}

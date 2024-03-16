package data.models;

public class Entry {
    private String title;
    private String body;
    private String author;

    public Entry () {}
    public Entry(String title, String body, String author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }
}

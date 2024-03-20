package data.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDate dateCreated = LocalDate.now();

    public Entry(){

    }
    public Entry(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}

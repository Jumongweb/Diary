package data.models;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked = true;
    private int noOfEntries;
    private final List<Entry> entries = new ArrayList<>();

    public Diary(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

}

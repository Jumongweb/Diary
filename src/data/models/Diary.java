package data.models;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked = false;
    private int noOfEntries;
    private final List<Entry> entries = new ArrayList<>();

    public Diary(){ }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}

package com.example.naomidejong562748endassignment.model;

public class User {
    private int identifier;
    private String username;
    private String password;

    public User(int identifier, String username, String password) {
        this.identifier = identifier;
        this.username = username;
        this.password = password;
    }

    public int getIdentifier(){return identifier;}
    public String getUsername(){return username;}
    public String getPassword() {return password;}
}

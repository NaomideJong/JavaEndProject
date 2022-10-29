package com.example.naomidejong562748endassignment.model;

import java.time.LocalDate;

public class User {
    private int Indentifier;
    private String Username;
    private String Password;

    public User(int indentifier, String username, String password) {
        Indentifier = indentifier;
        Username = username;
        Password = password;
    }

    public int getIndentifier(){return Indentifier;}
    public String getUsername(){return Username;}
    public String getPassword() {return Password;}
}

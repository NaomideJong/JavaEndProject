package com.example.naomidejong562748endassignment.model;

import java.time.LocalDate;

public class User {
    public int Identifier;
    public String FirstName;
    public String LastName;
    public LocalDate Birthday;
    public String Password;

    public User(int identifier, String firstName, String lastName, LocalDate birthday, String password) {
        Identifier = identifier;
        FirstName = firstName;
        LastName = lastName;
        Birthday = birthday;
        Password = password;
    }

    public int getIdentifier(){return Identifier;}

    public String getFirstName(){return FirstName;}

    public String getLastName() {return LastName;}

    public LocalDate getBirthday() {return Birthday;}

    public String getPassword() {return Password;}
}

package com.example.naomidejong562748endassignment.model;

import java.time.LocalDate;

public class Member {
    public int Identifier;
    public String FirstName;
    public String LastName;
    public LocalDate Birthday;

    public Member(int identifier, String firstName, String lastName, LocalDate birthday) {
        Identifier = identifier;
        FirstName = firstName;
        LastName = lastName;
        Birthday = birthday;
    }

    public int getIdentifier(){return Identifier;}

    public String getFirstName(){return FirstName;}

    public String getLastName() {return LastName;}

    public LocalDate getBirthday() {return Birthday;}
}

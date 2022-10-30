package com.example.naomidejong562748endassignment.model;

import java.time.LocalDate;

public class Member {
    private int identifier;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public Member(int identifier, String firstName, String lastName, LocalDate birthday) {
        this.identifier = identifier;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public int getIdentifier(){return identifier;}

    public String getFirstName(){return firstName;}

    public String getLastName() {return lastName;}

    public LocalDate getBirthday() {return birthday;}
}

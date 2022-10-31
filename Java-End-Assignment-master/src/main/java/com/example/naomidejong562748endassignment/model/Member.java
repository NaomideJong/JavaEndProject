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

    //setters
    public void setIdentifier(int identifier){this.identifier = identifier;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void setBirthday(LocalDate birthday){this.birthday = birthday;}

    //getters
    public int getIdentifier(){return identifier;}

    public String getFirstName(){return firstName;}

    public String getLastName() {return lastName;}

    public LocalDate getBirthday() {return birthday;}
}

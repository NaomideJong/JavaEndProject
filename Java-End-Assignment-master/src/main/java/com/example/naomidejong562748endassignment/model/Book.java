package com.example.naomidejong562748endassignment.model;

import java.time.LocalDate;
import java.util.Optional;

public class Book {
    private int itemcode;
    private String availability;
    private String title;
    private String author;

    public Book(int itemcode, String availability, String title, String author) {
        this.itemcode = itemcode;
        this.availability = availability;
        this.title = title;
        this.author = author;
    }

    //getters
    public int getItemcode() {return itemcode;}
    public String getAvailability() {return availability;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}

    //setters
    public void setItemCode(int itemcode) {
        this.itemcode = itemcode;
    }
    public void setAvailability(String availability){this.availability = availability;}
    public void setTitle(String title){this.title = title;}
    public void setAuthor(String author){this.author = author;}
}

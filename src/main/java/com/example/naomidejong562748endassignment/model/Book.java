package com.example.naomidejong562748endassignment.model;

public class Book {
    public int Itemcode;
    public boolean Availability;
    public String Title;
    public String Author;

    public Book(int itemcode, boolean availability, String title, String author) {
        Itemcode = itemcode;
        Availability = availability;
        Title = title;
        Author = author;
    }

    public int getItemcode() {return Itemcode;}

    public boolean isAvailable() {return Availability;}

    public String getTitle() {return Title;}

    public String getAuthor() {return Author;}
}

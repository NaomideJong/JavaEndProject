package com.example.naomidejong562748endassignment.database;

import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    public List<User> getUsers(){return users;}

    public List<Book> getBooks(){return books;}

    public Database(){
        //users
        users.add(new User(10, "Naomi","de Jong", LocalDate.parse("1996-07-10"), "pass123"));
        users.add(new User(11, "Dean","Winchester", LocalDate.parse("1997-01-24"), "pass123"));
        users.add(new User(12, "Adam","Milligan", LocalDate.parse("1990-09-29"), "pass123"));
        users.add(new User(13, "Jack","Kleine", LocalDate.parse("2017-05-18"), "pass123"));
        users.add(new User(13, "Chuck","Shurley", LocalDate.parse("1907-09-21"), "pass123"));

        //books
        books.add(new Book(210, true, "Tears of War", "G.F. Blackmore"));
        books.add(new Book(211, true, "Tapped for Evil", "M.A. Pittampalli"));
        books.add(new Book(212, true, "The Spell in the Winter", "G. F. Blackmore"));
        books.add(new Book(213, true, "TommyInnit Says...The Quote Book", "T. Simons, W. Gold"));
        books.add(new Book(214, true, "Maybe, Probably", "J.K. Williamson"));
        books.add(new Book(215, true, "Supernatural", "C. Edlund"));
        books.add(new Book(216, true, "Shroud the Spider", "T. Bee"));
        books.add(new Book(217, true, "Redstone", "J. Cordeiro"));
        books.add(new Book(218, true, "Why not to shoot zombies", "B. Singer"));
    }
}
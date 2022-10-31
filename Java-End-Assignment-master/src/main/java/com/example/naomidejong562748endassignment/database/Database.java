package com.example.naomidejong562748endassignment.database;

import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.LendOut;
import com.example.naomidejong562748endassignment.model.Member;
import com.example.naomidejong562748endassignment.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class Database{
    String line;
    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private List<LendOut> lendOut = new ArrayList<>();


    //getters
    public List<User> getUsers(){return users;}
    public List<Member> getMembers(){return members;}
    public List<Book> getBooks(){return books;}
    public List<LendOut> getLendOut(){return lendOut;}

    //setters
    public void setBooks(List<Book> books){this.books = books;}
    public void setMembers(List<Member> members){this.members = members;}
    public void setLendOut(List<LendOut> lendOut){this.lendOut = lendOut;}

    public Database(){
        try {
            BufferedReader bookReader = new BufferedReader(new FileReader("books.csv"));
            String headerBookLine = bookReader.readLine();
            while ((line = bookReader.readLine()) !=  null) {
                String[] bookCsv = line.split(",");

                Book book = new Book(parseInt(bookCsv[0]), bookCsv[1], bookCsv[2], bookCsv[3]);
                books.add(book);
            }
            BufferedReader memberReader = new BufferedReader(new FileReader("members.csv"));
            String headerMemberLine = memberReader.readLine();
            while ((line = memberReader.readLine()) !=  null) {
                String[] memberCsv = line.split(",");

                Member member = new Member(parseInt(memberCsv[0]), memberCsv[1], memberCsv[2], LocalDate.parse(memberCsv[3]));
                members.add(member);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        //users
        users.add(new User(10, "Naomi", "pass123"));
        users.add(new User(11, "Dean", "impala67"));
        users.add(new User(12, "Adam", "baseball99"));
        users.add(new User(13, "Jack", "twinkie3"));
        users.add(new User(14, "Chuck", "ohlord00"));

        //lend out books
        lendOut.add(new LendOut(213, 10, LocalDate.parse("2022-10-30")));
        lendOut.add(new LendOut(215, 10, LocalDate.parse("2000-10-10")));
        lendOut.add(new LendOut(218, 10, LocalDate.parse("2022-10-08")));
        lendOut.add(new LendOut(219, 14, LocalDate.parse("2022-10-29")));

        if(books.isEmpty()) {

            //members
            members.add(new Member(10, "Naomi", "de Jong", LocalDate.parse("1996-07-10")));
            members.add(new Member(11, "Dean", "Winchester", LocalDate.parse("1997-01-24")));
            members.add(new Member(12, "Adam", "Milligan", LocalDate.parse("1990-09-29")));
            members.add(new Member(13, "Jack", "Kleine", LocalDate.parse("2017-05-18")));
            members.add(new Member(14, "Chuck", "Shurley", LocalDate.parse("1907-09-21")));

            //books
            books.add(new Book(210, "Yes", "Tears of War", "G.F. Blackmore"));
            books.add(new Book(211, "Yes", "Tapped for Evil", "M.A. Pittampalli"));
            books.add(new Book(212, "Yes", "The Spell in the Winter", "G. F. Blackmore"));
            books.add(new Book(213, "No", "TommyInnit Says...", "T. Simons, W. Gold"));
            books.add(new Book(214, "Yes", "Maybe, Probably", "J.K. Williamson"));
            books.add(new Book(215, "No", "Supernatural", "C. Edlund"));
            books.add(new Book(216, "Yes", "Shroud the Spider", "T. Bee"));
            books.add(new Book(217, "Yes", "Redstone", "M. Jumbo"));
            books.add(new Book(218, "No", "Why not to shoot zombies", "B. Singer"));
            books.add(new Book(219, "No", "Art Of War", "S. Tzu"));
        }

    }
}

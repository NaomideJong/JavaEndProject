package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.List;

public class BookCRUDController {

    protected Database database;
    protected Book selectedBook;
    protected List<Book> books;

    public BookCRUDController(Database database, Book selectedBook) {
        this.database = database;
        this.selectedBook = selectedBook;
        this.books = database.getBooks();
    }

    protected void closeStage(ActionEvent actionEvent){
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Optional;

public class BookAddController extends BookCRUDController {
    @FXML
    TextField titleField;
    @FXML
    TextField authorField;

    public BookAddController(Database database, Book selectedBook) {
        super(database, selectedBook);
    }

    @FXML
    private void addButtonClick(ActionEvent actionEvent){
        Book lastBook = database.getBooks().get(database.getBooks().size() - 1);
        int code = lastBook.getItemcode() +1;
        books.add(new Book(code, "Yes", titleField.getText(), authorField.getText()));
        database.setBooks(books);
        closeStage(actionEvent);
    }

    @FXML
    private void cancelButtonClick(ActionEvent actionEvent){
        closeStage(actionEvent);
    }

}

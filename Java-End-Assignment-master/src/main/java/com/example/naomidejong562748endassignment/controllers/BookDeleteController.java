package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookDeleteController extends BookCRUDController implements Initializable {
@FXML
Label bookTitleLabel;
    public BookDeleteController(Database database, Book selectedBook) {
        super(database, selectedBook);
    }

    @FXML
    private void confirmButtonClick(ActionEvent actionEvent){
        books.remove(books.indexOf(selectedBook));
        database.setBooks(books);
        closeStage(actionEvent);
    }
    @FXML
    private void cancelButtonClick(ActionEvent actionEvent){
        closeStage(actionEvent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookTitleLabel.setText(selectedBook.getTitle());
    }
}

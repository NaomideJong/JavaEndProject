package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class BookListController{
    @FXML
    TableView bookTable;

    private Database database;
    private ObservableList<Book> books;
    private Book selectedBook;
    public BookListController(Database database) {
        this.database = database;
        fillTable();
    }

    private void fillTable(){
        books = FXCollections.observableArrayList(database.getBooks());
        bookTable.setItems(books);
        bookTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedBook = (Book)newSelection;
            }
        });
    }

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        books = FXCollections.observableArrayList(database.getBooks());
        bookTable.setItems(books);
        bookTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedBook = (Book)newSelection;
            }
        });
    }*/
}

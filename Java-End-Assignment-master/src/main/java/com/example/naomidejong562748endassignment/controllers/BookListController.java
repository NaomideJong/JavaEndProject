package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.App;
import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookListController implements Initializable{
    @FXML
    TableView<Book> bookTable;

    private Database database;
    private ObservableList<Book> books;
    private Book selectedBook;

    public BookListController(Database database){this.database = database;}

    public void addItemButtonClick(ActionEvent actionEvent) {
        bookCRUD("AddBookWindow.fxml", "Add Book", new BookAddController(database, selectedBook));
    }
    public void editItemButtonClick(ActionEvent actionEvent) {
        if(selectedBook != null) {
            bookCRUD("EditBookWindow.fxml", "Edit Book", new BookEditController(database, selectedBook));
        }
    }
    public void deleteItemButtonClick(ActionEvent actionEvent) {
        if(selectedBook != null) {
            bookCRUD("DeleteBookWindow.fxml", "Delete Book", new BookDeleteController(database, selectedBook));
        }
    }

    private void bookCRUD(String window, String title, Object controller){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(window));
            fxmlLoader.setController(controller);
            new BookCRUDController(database, selectedBook);
            Scene scene = new Scene(fxmlLoader.load());
            Stage dialog = new Stage();
            dialog.setScene(scene);
            dialog.setTitle(title);
            dialog.showAndWait();

            books = FXCollections.observableArrayList(database.getBooks());
            bookTable.getItems().clear();
            bookTable.setItems(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        books = FXCollections.observableArrayList(database.getBooks());
        bookTable.setItems(books);
        bookTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedBook = (Book)newSelection;
                bookTable.setItems(books);
            }
        });
    }
}

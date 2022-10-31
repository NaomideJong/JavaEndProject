package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class BookEditController extends BookCRUDController implements Initializable{
    private Book editedBook;
    @FXML
    TextField titleField;
    @FXML
    TextField authorField;
    @FXML
    TextField codeField;
    @FXML
    ComboBox<String> availableComboBox;

    public BookEditController(Database database, Book selectedBook) {
        super(database, selectedBook);
    }

    @FXML
    private void editButtonClick(ActionEvent actionEvent){
        try {
            int check = parseInt(codeField.getText());
            books.set(books.indexOf(selectedBook), editBook());
            database.setBooks(books);
            closeStage(actionEvent);

        } catch (NumberFormatException e) {
            codeField.setText(valueOf(selectedBook.getItemcode()));
        }
    }

    private Book editBook() {
        editedBook.setItemCode(parseInt(codeField.getText()));
        editedBook.setAvailability(availableComboBox.getValue());
        editedBook.setTitle(titleField.getText());
        editedBook.setAuthor(authorField.getText());

        return editedBook;
    }

    @FXML
    private void cancelButtonClick(ActionEvent actionEvent){
        closeStage(actionEvent);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        availableComboBox.getItems().add("Yes");
        availableComboBox.getItems().add("No");
        editedBook = selectedBook;
        codeField.setText(valueOf(selectedBook.getItemcode()));
        availableComboBox.setValue(selectedBook.getAvailability());
        titleField.setText(selectedBook.getTitle());
        authorField.setText(selectedBook.getAuthor());
    }
}

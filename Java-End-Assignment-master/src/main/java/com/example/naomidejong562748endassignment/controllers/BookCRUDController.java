package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.tableview2.cell.TextField2TableCell;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class BookCRUDController implements Initializable {
    private Database database;
    private Book book;
    private Book selectedBook;
    @FXML
    TextField titleField;
    @FXML
    TextField authorField;
    @FXML
    TextField codeField;
    @FXML
    ComboBox<String> availableComboBox;


    public BookCRUDController(Database database, Book selectedBook) {
        this.database = database;
        this.selectedBook = selectedBook;
    }

    public Book getBooks(){
        return book;
    }

    @FXML
    private void addButtonClick(ActionEvent actionEvent){
        Book lastBook = database.getBooks().get(database.getBooks().size() - 1);
        int code = lastBook.getItemcode() +1;
        book = new Book(code, "Yes",titleField.getText(), authorField.getText());
        closeStage(actionEvent);
    }
    @FXML
    private void editButtonClick(ActionEvent actionEvent){
        //THIS SHOULD HAPPEN IN INIT maybe..
        List<Book> books = database.getBooks();
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Yes",
                        "No"
                );
        ComboBox comboBox = new ComboBox(options);
        books.set(books.indexOf(selectedBook), editBook());
    }

    private Book editBook() {
        Book editedBook = selectedBook;
        codeField.setText(valueOf(selectedBook.getItemcode()));
        availableComboBox.setValue("Yes");
        titleField.setText(selectedBook.getTitle());
        authorField.setText(selectedBook.getAuthor());

        editedBook.setItemCode(parseInt(codeField.getText()));
        editedBook.setAvailability(availableComboBox.getValue());
        editedBook.setTitle(titleField.getText());
        editedBook.setTitle(authorField.getText());

        return editedBook;
    }
    @FXML
    private void confirmButtonClick(ActionEvent actionEvent){

    }


    @FXML
    private void cancelButtonClick(ActionEvent actionEvent){
        closeStage(actionEvent);
    }
    private void closeStage(ActionEvent actionEvent){
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    public static void numericOnly(TextField field) {
        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(
                    ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    field.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

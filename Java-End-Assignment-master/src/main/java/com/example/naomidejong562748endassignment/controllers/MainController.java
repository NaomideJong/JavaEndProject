package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.App;
import com.example.naomidejong562748endassignment.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {
    private Database database;

    public void membersButtonClick(ActionEvent actionEvent) {
    }

    public void collectionButtonClick(ActionEvent actionEvent) {
        new BookListController(database);
    }

    public void lendMenuButtonClick(ActionEvent actionEvent) {
    }

    public void lendButtonClick(ActionEvent actionEvent) {
    }

    public void recieveButtonClick(ActionEvent actionEvent) {
    }
}

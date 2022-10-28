package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MainController{
    private Database database;
    private User currentUser;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Pane lendReceiveTab;
    @FXML
    private Pane collectionTab;
    @FXML
    private Pane memberTab;
    MainController() {
        //welcomeLabel.setText(String.format("Welcome %s %s!", currentUser.getFirstName(), currentUser.getLastName()));
    }
    public void setUser(User user){currentUser = user;}

    public void membersButtonClick(ActionEvent actionEvent) {
        memberTab.toFront();
    }

    public void collectionButtonClick(ActionEvent actionEvent) {
        collectionTab.toFront();
        new BookListController(database);
    }

    public void lendMenuButtonClick(ActionEvent actionEvent) {
        lendReceiveTab.toFront();
    }

    public void lendButtonClick(ActionEvent actionEvent) {
    }

    public void receiveButtonClick(ActionEvent actionEvent) {
    }
}

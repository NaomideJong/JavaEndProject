package com.example.naomidejong562748endassignment.controllers;

import java.io.IOException;
import java.util.Objects;

import com.example.naomidejong562748endassignment.App;
import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.User;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    private Database database;
    private ObservableList<User> users;
    private User currentUser;
    private MainController mainController;

    public LoginController(){
        this.database = new Database();
        users = FXCollections.observableArrayList(database.getUsers());
    }

    @FXML
    private Label errorLabel;
    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    protected void logInButtonClick() throws IOException {
        if(checkPassword()){
            mainController = new MainController(database, currentUser);
            App.setRoot("MainWindow", mainController);
            }
        else{errorLabel.setVisible(true);}
    }


    protected boolean checkPassword(){
        if (userField != null && passField != null) {
            String currentUsername = userField.getText();
            String currentPass = passField.getText();

            for (User user: users)
                if (Objects.equals(user.getUsername(), currentUsername)) {
                        currentUser = user;
                        return Objects.equals(user.getPassword(), currentPass);
                }
        }
        return false;
    }
}
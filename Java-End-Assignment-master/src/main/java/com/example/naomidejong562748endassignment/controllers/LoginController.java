package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.App;
import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    private Database database;
    private ObservableList<User> users;

    public LoginController(){
        this.database = new Database();
        users = FXCollections.observableArrayList(database.getUsers());
    }

    @FXML
    protected void logInButtonClick() throws IOException {
        Label error = new Label("errorLabel");
        if(checkPassword()){App.setRoot("MainWindow");}
        else{ error.setVisible(true);}
    }

    protected boolean checkPassword(){
        TextField userField = new TextField("userField");
        TextField passField = new TextField("passField");
        String currentUser = userField.getText();
        String currentPass = passField.getText();

        for (User user: users) {
            if(Objects.equals(user.getFirstName(), currentUser)){
                if(Objects.equals(user.getPassword(), currentPass)){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
}
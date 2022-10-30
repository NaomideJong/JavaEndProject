package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LendReceiveController implements Initializable {
    private Database database;
    @FXML
    private Label welcomeLabel;
    private Member currentMember;

    public LendReceiveController(Database database, Member currentMember){
        this.database = database;
        this.currentMember = currentMember;
    }
    public void lendButtonClick(ActionEvent actionEvent) {
    }

    public void receiveButtonClick(ActionEvent actionEvent) {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       welcomeLabel.setText(String.format("Welcome %s %s!", currentMember.getFirstName(), currentMember.getLastName()));
    }
}

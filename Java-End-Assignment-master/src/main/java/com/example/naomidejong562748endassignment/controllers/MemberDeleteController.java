package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberDeleteController extends MemberCRUDController implements Initializable {

    @FXML
    Label nameLabel;

    public MemberDeleteController(Database database, Member selectedMember) {
        super(database, selectedMember);
    }

    @FXML
    private void confirmButtonClick(ActionEvent actionEvent){
        members.remove(members.indexOf(selectedMember));
        database.setMembers(members);
        closeStage(actionEvent);
    }
    @FXML
    private void cancelButtonClick(ActionEvent actionEvent){
        closeStage(actionEvent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(selectedMember.getFirstName());
    }
}

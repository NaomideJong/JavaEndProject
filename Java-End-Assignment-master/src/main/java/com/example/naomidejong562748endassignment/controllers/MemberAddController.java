package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class MemberAddController extends MemberCRUDController{
    @FXML
    TextField firstNameField;
    @FXML
    TextField lastNameField;
    @FXML
    DatePicker birthdayDatePicker;


    public MemberAddController(Database database, Member selectedMember) {
        super(database, selectedMember);
    }

    @FXML
    private void addButtonClick(ActionEvent actionEvent){
        Member lastMember = database.getMembers().get(database.getMembers().size() - 1);
        int code = lastMember.getIdentifier() +1;
        members.add(new Member(code, firstNameField.getText(), lastNameField.getText(), birthdayDatePicker.getValue()));
        database.setMembers(members);
        closeStage(actionEvent);
    }

    @FXML
    private void cancelButtonClick(ActionEvent actionEvent){
        closeStage(actionEvent);
    }
}

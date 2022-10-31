package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class MemberEditController extends MemberCRUDController implements Initializable {

    private Member editedmember;

    @FXML
    TextField firstNameField;
    @FXML
    TextField lastNameField;
    @FXML
    TextField identifierField;

    @FXML
    DatePicker birthdayDatePicker;


    public MemberEditController(Database database, Member selectedMember) {
        super(database, selectedMember);
    }

    @FXML
    private void editButtonClick(ActionEvent actionEvent){
        try {
            int check = parseInt(identifierField.getText());
            members.set(members.indexOf(selectedMember), editMember());
            database.setMembers(members);
            closeStage(actionEvent);
        } catch (NumberFormatException e) {
            identifierField.setText(valueOf(selectedMember.getIdentifier()));
        }
    }

    private Member editMember() {
        editedmember.setIdentifier(Integer.parseInt(identifierField.getText()));
        editedmember.setFirstName(firstNameField.getText());
        editedmember.setLastName(lastNameField.getText());
        editedmember.setBirthday(birthdayDatePicker.getValue());

        return editedmember;
    }

    @FXML
    private void cancelButtonClick(ActionEvent actionEvent){
        closeStage(actionEvent);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        editedmember = selectedMember;
        identifierField.setText(valueOf(selectedMember.getIdentifier()));
        firstNameField.setText(selectedMember.getFirstName());
        lastNameField.setText(selectedMember.getLastName());
        birthdayDatePicker.setValue(selectedMember.getBirthday());
    }

}

package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberController implements Initializable {
    @FXML
    TableView memberTable;

    private Database database;
    private ObservableList<Member> members;
    private Member selectedMember;

    public MemberController(Database database){this.database = database;}

    public void addMemberButtonClick(ActionEvent actionEvent) {

    }
    public void editMemberButtonClick(ActionEvent actionEvent) {

    }
    public void deleteMemberButtonClick(ActionEvent actionEvent) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        members = FXCollections.observableArrayList(database.getMembers());
        memberTable.setItems(members);
        memberTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedMember = (Member)newSelection;
                memberTable.setItems(members);
            }
        });
    }
}

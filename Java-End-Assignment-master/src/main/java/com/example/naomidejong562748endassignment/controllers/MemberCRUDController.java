package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.Member;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.List;

public class MemberCRUDController {
    protected Database database;
    protected Member selectedMember;
    protected List<Member> members;

    public MemberCRUDController(Database database, Member selectedMember) {
        this.database = database;
        this.selectedMember = selectedMember;
        this.members = database.getMembers();
    }
    protected void closeStage(ActionEvent actionEvent){
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}

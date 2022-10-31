package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.App;
import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MemberListController implements Initializable {
    @FXML
    TableView memberTable;

    private Database database;
    private ObservableList<Member> members;
    private Member selectedMember;

    public MemberListController(Database database){this.database = database;}

    public void addMemberButtonClick(ActionEvent actionEvent) {
        memberCRUD("AddMemberWindow.fxml", "Add Member", new MemberAddController(database, selectedMember));
    }
    public void editMemberButtonClick(ActionEvent actionEvent) {
        if(selectedMember != null) {
            memberCRUD("EditMemberWindow.fxml", "Edit Member", new MemberEditController(database, selectedMember));
        }
    }
    public void deleteMemberButtonClick(ActionEvent actionEvent) {
        if(selectedMember != null) {
            memberCRUD("DeleteMemberWindow.fxml", "Delete Member", new MemberDeleteController(database, selectedMember));
        }
    }
    private void memberCRUD(String window, String title, Object controller){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(window));
            fxmlLoader.setController(controller);
            new MemberCRUDController(database, selectedMember);
            Scene scene = new Scene(fxmlLoader.load());
            Stage dialog = new Stage();
            dialog.setScene(scene);
            dialog.setTitle(title);
            dialog.showAndWait();

            members = FXCollections.observableArrayList(database.getMembers());
            memberTable.getItems().clear();
            memberTable.setItems(members);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

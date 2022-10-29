package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.Member;
import com.example.naomidejong562748endassignment.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Database database;
    private User currentUser;
    private Member currentMember;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Pane lendReceiveTab;
    @FXML
    private Pane collectionTab;
    @FXML
    private Pane memberTab;

    private BookListController bookListController;
   public MainController(Database database, User currentUser){
        this.database = database;
        this.currentUser = currentUser;
        for (Member member: database.getMembers()) {
            if (currentUser.getIndentifier() == member.getIdentifier()) {
                currentMember = member;
            }
        }
       bookListController = new BookListController(database);
    }


    public void membersButtonClick(ActionEvent actionEvent) {
        memberTab.toFront();
    }

    public void collectionButtonClick(ActionEvent actionEvent) {
        collectionTab.toFront();
    }

    public void lendMenuButtonClick(ActionEvent actionEvent) {
        lendReceiveTab.toFront();
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

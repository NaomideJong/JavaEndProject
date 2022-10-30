package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.App;
import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Member;
import com.example.naomidejong562748endassignment.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Database database;
    private User currentUser;
    private Member currentMember;
    @FXML
    HBox layout;

   public MainController(Database database, User currentUser){
        this.database = database;
        this.currentUser = currentUser;
        for (Member member: database.getMembers()) {
            if (currentUser.getIdentifier() == member.getIdentifier()) {
                currentMember = member;
            }
        }
    }
    public void loadScene(String name, Object controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(name));
            fxmlLoader.setController(controller);
            Scene scene = new Scene(fxmlLoader.load());
            if (layout.getChildren().size() > 1)
                layout.getChildren().remove(1);
                layout.getChildren().add(scene.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void membersButtonClick(ActionEvent actionEvent) {
        loadScene("MemberWindow.fxml", new MemberController(database));
    }

    public void collectionButtonClick(ActionEvent actionEvent) {
        loadScene("BookWindow.fxml", new BookListController(database));
    }

    public void lendMenuButtonClick(ActionEvent actionEvent) {
        loadScene("LendReceiveWindow.fxml", new LendReceiveController(database, currentMember));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadScene("LendReceiveWindow.fxml", new LendReceiveController(database, currentMember));
    }

}

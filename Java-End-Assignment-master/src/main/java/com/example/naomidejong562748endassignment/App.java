package com.example.naomidejong562748endassignment;

import com.example.naomidejong562748endassignment.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        LoginController login = new LoginController();
        scene = new Scene(loadFXML("LoginScreen", login));
        stage.setScene(scene);
        stage.setTitle("Naomi's Library System");
        stage.show();
    }

    public static void setRoot(String fxml, Object controller) throws IOException {
        scene.setRoot(loadFXML(fxml, controller));
    }

    private static Parent loadFXML(String fxml, Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setController(controller);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
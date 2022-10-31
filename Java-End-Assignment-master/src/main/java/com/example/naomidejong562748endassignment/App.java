package com.example.naomidejong562748endassignment;

import com.example.naomidejong562748endassignment.controllers.LoginController;
import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.Member;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class App extends Application {

    private static Scene scene;
    private static Database database;
    @Override
    public void start(Stage stage) throws IOException {
        database = new Database();
        LoginController login = new LoginController(database);
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
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                writeMembers();
                writeBooks();
            }
        }, "Write"));
    }
    public static void writeMembers(){
        try{
            BufferedWriter memberWriter = new BufferedWriter(new FileWriter("members.csv", false));
            memberWriter.write("identifier,firstName,lastName,birthday");
            List<Member> members = database.getMembers();
            for (Member member: members) {
                int identifier = member.getIdentifier();
                String firstName = member.getFirstName();
                String lastName = member.getLastName();
                String birthday = member.getBirthday().toString();
                String line = String.format("%d,%s,%s,%s", identifier, firstName, lastName, birthday);
                memberWriter.newLine();
                memberWriter.write(line);
            }
            memberWriter.close();

        }catch (IOException e) {
            System.out.println("Couldn't write members");
        }
    }
    public static void writeBooks(){
        try{
            BufferedWriter bookWriter = new BufferedWriter(new FileWriter("books.csv", false));
            bookWriter.write("itemcode,availability,title,author");
            List<Book> books = database.getBooks();
            for (Book book: books) {
                int itemcode = book.getItemcode();
                String availability = book.getAvailability();
                String title = book.getTitle();
                String author = book.getAuthor();
                String line = String.format("%d,%s,%s,%s", itemcode, availability, title, author);
                bookWriter.newLine();
                bookWriter.write(line);
            }
            bookWriter.close();

        }catch (IOException e) {
            System.out.println("Couldn't write books");
        }
    }
}
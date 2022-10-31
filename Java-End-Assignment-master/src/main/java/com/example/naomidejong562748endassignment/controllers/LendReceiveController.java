package com.example.naomidejong562748endassignment.controllers;

import com.example.naomidejong562748endassignment.database.Database;
import com.example.naomidejong562748endassignment.model.Book;
import com.example.naomidejong562748endassignment.model.LendOut;
import com.example.naomidejong562748endassignment.model.Member;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.time.temporal.ChronoUnit.DAYS;

public class LendReceiveController implements Initializable {
    private Database database;
    private Member currentMember;
    private Book book;
    private LendOut receive;
    private List<LendOut> lendList;
    private List<Book> books;
    private List<Member> members;

    @FXML
    private Label welcomeLabel;
    @FXML
    private Label errorLendLabel;
    @FXML
    private Label errorReceiveLabel;
    @FXML
    private TextField lendItemField;
    @FXML
    private TextField lendMemberField;
    @FXML
    private TextField receiveItemField;

    public LendReceiveController(Database database, Member currentMember){
        this.database = database;
        this.currentMember = currentMember;
        this.lendList = database.getLendOut();
        this.books = database.getBooks();
        this.members = database.getMembers();
    }

    @FXML
    public void lendButtonClick(ActionEvent actionEvent) {
        if (checkLendOut()) {
            if (Objects.equals(book.getAvailability(), "Yes")) {
                book.setAvailability("No");
                books.set(books.indexOf(book), book);
                lendList.add(new LendOut(parseInt(lendItemField.getText()), parseInt(lendMemberField.getText()), LocalDate.now()));
                database.setLendOut(lendList);
                database.setBooks(books);
                errorLendLabel.setText(String.format("%s lend!", book.getTitle()));
            } else {
                errorLendLabel.setText("Book unavailable");
            }
        } else errorLendLabel.setText("Item code/member id not found");
    }

    public boolean checkLendOut(){
        try{
            for (Book book: books) {
                if(parseInt(lendItemField.getText()) == book.getItemcode()){
                    this.book = book;
                    for (Member member: members) {
                        if (parseInt(lendMemberField.getText()) == member.getIdentifier()){
                            return true;
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            errorLendLabel.setText("Please only enter numbers");
        }
        return false;
    }

    @FXML
    public void receiveButtonClick(ActionEvent actionEvent) {
        try{
            int currentItem = parseInt(receiveItemField.getText());
            if(returnBook(currentItem)) checkInTime();
            else errorReceiveLabel.setText("Itemcode not found");
        } catch (NumberFormatException e) {
            errorReceiveLabel.setText("Please only enter numbers");
        }
    }
    public boolean returnBook(int currentItem){
        try{
            for (LendOut lend: lendList) {
                if(currentItem == lend.getItemcode()){
                    receive = lend;
                    lendList.remove(lend);
                    database.setLendOut(lendList);
                    for (Book book: books) {
                        if(receive.getItemcode() == book.getItemcode()){
                            book.setAvailability("Yes");
                            this.book = book;
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (NumberFormatException e) {
            errorReceiveLabel.setText("Itemcode not found");
            return false;
        }
    }


    public void checkInTime(){
        int days = parseInt(String.valueOf(DAYS.between(receive.getLendDate(), LocalDate.now())));
        if(days > 21){
            int late = days - 21;
            errorReceiveLabel.setText(String.format("%s\nreturned %d\nday(s) too late!", book.getTitle(), late));
        }
        else errorReceiveLabel.setText(String.format("%s\nsuccessfully returned!", book.getTitle()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       welcomeLabel.setText(String.format("Welcome %s %s!", currentMember.getFirstName(), currentMember.getLastName()));
    }
}

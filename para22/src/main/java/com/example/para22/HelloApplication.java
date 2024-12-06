package com.example.para22;

import javafx.application.Application;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.IOException;

public class HelloApplication extends Application {
    public Button proverka;
    BD bd=new BD();
    public TextField event_event_name;
    @FXML public ComboBox event_member_fullname;
    @FXML public ComboBox event_sponsor_name;
    public Button event_add;

    public TextField location_location_name;
    @FXML public ComboBox location_event_name;
    public Button location_add;

    public TextField member_member_surname;
    public TextField member_member_name;
    public TextField member_member_lastname;
    public Button member_add;

    public TextField sponsor_sponsor_name;
    public TextField sponsor_how_much;
    public Button sponsor_add;

    public TextField ticket_ticket_owner;
    @FXML public ComboBox ticket_event_name;
    public Button ticket_add;

    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Как же я устал от этого");
        stage.setScene(scene);
        stage.show();
    }
    private void initialize() {
        event_member_fullname.getItems().addAll(bd.getMembers());
        event_sponsor_name.getItems().addAll(bd.getSponsors());
        location_event_name.getItems().addAll(bd.getEvents());
        ticket_event_name.getItems().addAll(bd.getEvents());
    }
    public void adding_event(ActionEvent actionEvent) {
        String eventname = event_event_name.getText();
        Members selectedMember_event = (Members) event_member_fullname.getValue();
        Sponsors selectedSponsor_event = (Sponsors) event_sponsor_name.getValue();
        if (eventname.isEmpty()||selectedMember_event==null||selectedSponsor_event==null)
        {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }

        else if (bd.getEvents().contains(eventname)) {
            JOptionPane.showMessageDialog(null, "Такое событие уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
        else bd.addEvent(eventname,selectedMember_event.getId(), selectedSponsor_event.getId());
    }

    public void adding_location(ActionEvent actionEvent) {
        String locationname = location_location_name.getText();
        Events selectedEvent_location = (Events) location_event_name.getValue();
        if (locationname.isEmpty() || selectedEvent_location == null) {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        } else {
            bd.addLocation(locationname, selectedEvent_location.getId());
        }
    }
    public void adding_member(ActionEvent actionEvent) {
        String surname = member_member_surname.getText();
        String name = member_member_name.getText();
        String lastname = member_member_lastname.getText();
        String full = surname + " " + name + " " + lastname;
        if (surname.isEmpty() || name.isEmpty() || lastname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        } else if (bd.getMembers().contains(full)) {
            JOptionPane.showMessageDialog(null, "Такой участник уже есть", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        } else {
            bd.addMember(surname, name, lastname);
        }
    }

    public void adding_sponsor(ActionEvent actionEvent) {
        String sponsorname = sponsor_sponsor_name.getText();
        int money = Integer.parseInt(sponsor_how_much.getText());
        if (sponsorname.isEmpty() || money == 0) {
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        } else {
            bd.addSponsor(sponsorname, money);
        }
    }

    public void adding_ticket(ActionEvent actionEvent) {
        String ticketowner=ticket_ticket_owner.getText();
        Events selectedEvent_ticket=(Events) ticket_event_name.getValue();
        if(ticketowner.isEmpty()||selectedEvent_ticket==null){
            JOptionPane.showMessageDialog(null, "Заполните все поля", "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        } else {
            bd.addTickets(ticketowner,selectedEvent_ticket.getId());
        }
    }

    public void proveriaem(ActionEvent actionEvent) {
        initialize();
    }
}
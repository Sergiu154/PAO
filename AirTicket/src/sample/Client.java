package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client implements Print {
    private String firstName;
    private String lastName;
    private String email;
    private int numOfTickets;

    public int getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private List<Ticket> tickets;
    private String dateOfBirth;

    public Client() {

        firstName = "";
        lastName = "";
        dateOfBirth = "";
        tickets = new ArrayList<>();
    }

    public Client(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void printTicket(VBox placeText, Ticket t) {


        List<String> info = t.getTicketInfo();

        info.add(0, "Email: " + email);
        info.add(0, "Name: " + firstName + " " + lastName);

        for (String s : info) {

            Label b = new Label(s);
            b.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold");
            placeText.getChildren().add(b);
        }

    }

    public void addTicket(Ticket t) {

        tickets.add(t);
        Collections.sort(tickets);
        numOfTickets++;

    }

}

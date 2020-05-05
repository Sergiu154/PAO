package sample.services;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Ticket;

import java.time.format.DateTimeFormatter;

import java.io.IOException;


public class MainController {

    @FXML
    private DatePicker departureDate;

    @FXML
    private DatePicker returnDate;

    @FXML
    private TextField destination;

    @FXML
    private Spinner seatsNumber;

    @FXML
    private Button bookButton;

    @FXML
    private ProgressBar progressBar;


    @FXML
    private TextField departureLocation;


    @FXML
    private Button newOrder;


    @FXML
    private ToggleGroup group1;


    private static Ticket ticket;
    private static int numOfTickets;


    public void onBookPress(ActionEvent e) throws IOException {

        Stage stage = null;
        Parent root = null;

        if (e.getSource() == bookButton) {


            if (!departureLocation.getText().equals("") && !destination.getText().equals("") ||
                    ticket.getArrivalDate() != null && (ticket.getDepartureDate() != null || returnDate.isDisabled())) {


                numOfTickets = Integer.parseInt(seatsNumber.getValue().toString());
                System.out.println(numOfTickets);
                ticket.setDepartureLocation(departureLocation.getText());
                ticket.setArrivalLocation(destination.getText());

                if (numOfTickets > 0) {
                    stage = (Stage) bookButton.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("/scenes/flights.fxml"));
                }

            }


        } else if (e.getSource() == newOrder) {


            stage = (Stage) newOrder.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/sample.fxml"));
        }
        if (root != null && stage != null) {

            System.out.println("SASADADA");
            Scene scene = new Scene(root, 800, 700);
            stage.setScene(scene);
            stage.show();
        }


    }

    public void onTripType() {


        // display only the departureDate calendar when "One way" RadioButton is selected
        RadioButton typeOfTrip = (RadioButton) group1.getSelectedToggle();
        if (typeOfTrip.getText().equals("One way"))
            returnDate.setDisable(true);
        else
            returnDate.setDisable(false);

        departureDate.setDisable(false);

    }

    public static Ticket getTicket() {
        return ticket;
    }

    public static int getNumOfTickets() {
        return numOfTickets;
    }

    public void onDate(ActionEvent e) {


        progressBar.setProgress(progressBar.getProgress() + (1.0 - progressBar.getProgress()) / 4);


        // get the departureDate and returnDate and save them in a Ticket object
        if (e.getSource() == departureDate) {

            String temp = departureDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            ticket.setDepartureDate(temp);

        } else if (e.getSource() == returnDate) {

            ticket.setArrivalDate(returnDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        }


    }

    @FXML
    public void initialize() {

        ticket = new Ticket();
        if (departureDate != null && returnDate != null) {
            departureDate.setDisable(true);
            returnDate.setDisable(true);
        }


    }

    public void onTextInput() {

    }
}



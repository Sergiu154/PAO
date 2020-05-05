package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class InfoController {
    @FXML
    private Button printButton;

    @FXML
    private Button backInfo;

    @FXML
    private Button backButton;
    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private TextField emailAddress;

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;

    @FXML
    private ToggleGroup group2;

    @FXML
    private CheckBox luggageCheck;

    @FXML
    private CheckBox mealCheck;

    @FXML
    private CheckBox priorityCheck;

    private Ticket ticket;

    public static Client getClient() {
        return client;
    }

    private static Client client;

    private FirstClassTicket firstClassTicket;

    private static String clientPath = "src/csvFiles/client.csv";

    private static String firstClassPath = "src/csvFiles/firstclass.csv";


    @FXML
    public void initialize() {

        client = new Client();
        ticket = MainController.getTicket();
        priorityCheck.setDisable(true);
        mealCheck.setDisable(true);

    }


    public static String getClientPath() {
        return clientPath;
    }

    public static String getFirstClassPath() {
        return firstClassPath;
    }

    public void onInfoPress(ActionEvent e) throws IOException {

        Stage stage = null;
        Parent root = null;
        if (e.getSource() == printButton) {

            MainController.getAuditService().logAction("Am printat un bilet");

            client.setFirstName(firstName.getText());
            client.setLastName(lastName.getText());
            client.setEmail(emailAddress.getText());
            client.setDateOfBirth(dateOfBirth.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            client.addTicket(ticket);
            client.setNumOfTickets(ticket.getTicketNums());

            RadioButton selected = (RadioButton) group2.getSelectedToggle();


            // write client and firstTicket objects to their csv

            MainController.getCsvInstance().writeCSV(clientPath, client.toString());
            MainController.getCsvInstance().writeCSV(firstClassPath, ticket.toString() + "," + ticket.getOneWay());


            stage = (Stage) printButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/print_scene.fxml"));
        } else if (e.getSource() == backButton) {

            MainController.getAuditService().logAction("M-am intors sa selectez zborul");
            stage = (Stage) backButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/flights.fxml"));
        }

        if (root != null && stage != null) {

            Scene scene = new Scene(root, 800, 700);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void onDateInfo() {

        System.out.println(dateOfBirth.getValue());


    }

    public Ticket getTicket() {
        return ticket;
    }

    public void onTicketTypePress(ActionEvent e) {

        RadioButton selected = (RadioButton) group2.getSelectedToggle();
        if (selected.getText().equals("Business")) {

            firstClassTicket = new FirstClassTicket(ticket, true, true);

            priorityCheck.setSelected(true);
            mealCheck.setSelected(true);
        } else if (selected.getText().equals("Economy")) {
            priorityCheck.setSelected(false);
            mealCheck.setSelected(false);

        }
    }

    public void onCheckPress(ActionEvent e) {

        Boolean extraLuggage = false, menuIncluded = false, priority = false;

        if (e.getSource() == luggageCheck) {
            ticket.setExtraLuggage(luggageCheck.isSelected());
        }


    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.DB.AirportDB;
import sample.DB.ClientDB;
import sample.DB.FlightDB;
import sample.DB.TicketDB;
import sample.Ticket;

import java.time.format.DateTimeFormatter;


import java.io.IOException;
import java.util.List;


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
    private Button adminButton;


    @FXML
    private Button newOrder;

    public static CsvRW getCsvInstance() {
        return csvInstance;
    }

    public static void setCsvInstance(CsvRW csvInstance) {
        MainController.csvInstance = csvInstance;
    }

    @FXML
    private ToggleGroup group1;

    private static CsvRW csvInstance = CsvRW.getInstance();

    private static String path = "src/csvFiles/ticket.csv";


    private static Ticket ticket;
    private static int numOfTickets;

    public static AuditService getAuditService() {
        return auditService;
    }

    public static void setAuditService(AuditService auditService) {
        MainController.auditService = auditService;
    }

    private static AuditService auditService;


    public void onBookPress(ActionEvent e) throws IOException {

        Stage stage = null;
        Parent root = null;

        if (e.getSource() == bookButton) {


            if (!departureLocation.getText().equals("") && !destination.getText().equals("") ||
                    ticket.getArrivalDate() != null && (ticket.getDepartureDate() != null || returnDate.isDisabled())) {

                auditService.logAction("Am facut o rezervare");


                numOfTickets = Integer.parseInt(seatsNumber.getValue().toString());
                ticket.setTicketNums(numOfTickets);
                ticket.setDepartureLocation(departureLocation.getText());
                ticket.setArrivalLocation(destination.getText());

                csvInstance.writeCSV(path, ticket.toString());

                if (numOfTickets > 0) {
                    stage = (Stage) bookButton.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("/scenes/flights.fxml"));
                }

            }


        } else if (e.getSource() == newOrder) {


            stage = (Stage) newOrder.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/sample.fxml"));

        } else if (e.getSource() == adminButton) {
            System.out.println("Hello");
            stage = (Stage) adminButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/admin_scene.fxml"));

        }
        if (root != null && stage != null) {

            Scene scene = new Scene(root, 800, 700);
            stage.setScene(scene);
            stage.show();
        }


    }

    public void onTripType() {


        // display only the departureDate calendar when "One way" RadioButton is selected
        RadioButton typeOfTrip = (RadioButton) group1.getSelectedToggle();
        if (typeOfTrip.getText().equals("One way")) {

            ticket.setOneWay(true);
            returnDate.setDisable(true);
        } else {
            ticket.setOneWay(false);
            returnDate.setDisable(false);
        }

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

    // read the data from csv and load it
    void loadData() {

        List<Ticket> tickets = csvInstance.readCSV(path, (line) -> {

            String[] elements = line.split(",");
            return new Ticket(elements[0], elements[1], elements[2], elements[3], elements[4].matches("true"));

        });
        System.out.println("Tickets in the system");
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getDepartureLocation() + " " + ticket.getArrivalLocation() +
                    " " + ticket.getArrivalDate() + " " + ticket.getArrivalDate() + " One Way: " + ticket.getOneWay());
        }


        System.out.println("----------------------\nZboruri inregistrate");
        List<Flight> flights = csvInstance.readCSV(FlightController.getFlightPath(), (line) -> {

            String[] elements = line.split(",");
            return new Flight(elements[0], elements[1], elements[2]);

        });

        for (Flight flight : flights) {

            System.out.println(flight.getCompany() + " " + flight.getDate() + " " + flight.getTime());
        }


        System.out.println("----------------------------\nClienti inregistrati");
        List<Client> clients = csvInstance.readCSV(InfoController.getClientPath(), (line) -> {

            String[] elements = line.split(",");
            return new Client(elements[0], elements[1], elements[2], elements[3], Integer.parseInt(elements[4]));
        });

        for (Client client : clients) {

            System.out.println(client.getFirstName() + " " + client.getLastName() +
                    " " + client.getDateOfBirth() + " " + client.getEmail() + " " + client.getNumOfTickets());
        }


        System.out.println("-------------------------------\nFirst class tickets registered");
        List<FirstClassTicket> firstClassTickets = csvInstance.readCSV(InfoController.getFirstClassPath(), (line) -> {

            String[] elements = line.split(",");
            return new FirstClassTicket(elements[0], elements[1], elements[2], elements[3], elements[4].matches("true"), elements[5].matches("true"));

        });
        for (FirstClassTicket firstClassTicket : firstClassTickets) {

            System.out.println(firstClassTicket.getDepartureDate() + " " + firstClassTicket.getArrivalDate() + " " + firstClassTicket.getDepartureLocation() + " "
                    + firstClassTicket.getArrivalLocation() + " One way: " + firstClassTicket.getOneWay() + " Extra luggage: " + firstClassTicket.getExtraLuggage());
        }

    }

    @FXML
    public void initialize() {

        ticket = new Ticket();
        // get the audit service
        auditService = AuditService.getInstance();
        if (departureDate != null && returnDate != null) {
            departureDate.setDisable(true);
            returnDate.setDisable(true);
        }

        // load the data and print it to the console
        loadData();

        // create the table if it's not already created
        TicketDB ticketDB = TicketDB.getInstance();
        FlightDB flight = FlightDB.getInstance();
        ClientDB client = ClientDB.getInstance();
        AirportDB airportDB = AirportDB.getInstance();

    }

    public void onTextInput() {

    }
}



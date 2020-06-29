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

public class FlightController {


    @FXML
    private ToggleButton flightOption0;

    public static String getFlightPath() {
        return flightPath;
    }

    @FXML
    private ToggleButton flightOption1;

    @FXML
    private ToggleButton flightOption2;

    @FXML
    private Button nextButton1;

    @FXML
    private Button backLocation;

    @FXML
    private DatePicker flightDate;

    @FXML
    private TextField flightTime;

    @FXML
    private TextField flightCompany;

    @FXML
    private ToggleGroup t;

    private static String flightPath = "src/csvFiles/flights.csv";


    private Flight flight;


    public void onFlightSelected(ActionEvent e) {

        System.out.print("SALUT");

    }

    @FXML
    public void initialize() {

        t = new ToggleGroup();
        flight = new Flight();
        flightOption1.setToggleGroup(t);
        flightOption0.setToggleGroup(t);

    }

    public void onFlightDate(ActionEvent e) {

        if (e.getSource() == flightDate) {

            flight.setDate(flightDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        }
    }

    public void onNextPress(ActionEvent e) throws IOException {


        Stage stage = null;
        Parent root = null;


        if (e.getSource() == nextButton1) {

            MainController.getAuditService().logAction("Am ales un zbor");
            ToggleButton btn = (ToggleButton) t.getSelectedToggle();

            // daca am ales un zbor din cele prezente sau am adaugat eu toate datele pentru unul
            if (flight.getDate() != null && !flightTime.getText().matches("") && flightTime.getText().matches("([0-1][0-9]|2[0-4]):[0-5][0-9]") && !flightCompany.getText().matches("")) {

                flight.setCompany(flightCompany.getText());
                flight.setTime(flightTime.getText());

                MainController.getCsvInstance().writeCSV(flightPath, flight.toString());

                stage = (Stage) nextButton1.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/scenes/secondScene.fxml"));
            }


        } else {

            MainController.getAuditService().logAction("M-am intors sa selectez alte date de zbor");
            stage = (Stage) backLocation.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/sample.fxml"));

        }

        if (root != null && stage != null) {

            Scene scene = new Scene(root, 800, 700);
            stage.setScene(scene);
            stage.show();
        }


    }


}

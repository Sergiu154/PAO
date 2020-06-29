package sample.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sample.DB.FlightDB;
import sample.DB.TicketDB;
import sample.Flight;

import java.io.IOException;

public class FlightController {

    @FXML
    private Button findBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button removeBtn;
    @FXML
    private Button addBtn;
    @FXML
    private Button backBtn;

    @FXML
    private TextField addID;
    @FXML
    private TextField addCompany;
    @FXML
    private TextField addPlane;
    @FXML
    private TextField addDep;
    @FXML
    private TextField addArr;

    @FXML
    private TextField updateOption;

    @FXML
    private TextField updateID;

    @FXML
    private ToggleGroup group1;

    @FXML
    private TextField findID;

    @FXML
    private TextField removeID;

    public void onPress(ActionEvent e) throws IOException {


        Stage stage = null;
        Parent root = null;

        // back button
        if (e.getSource() == backBtn) {

            stage = (Stage) backBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/admin_scene.fxml"));


            if (root != null && stage != null) {

                Scene scene = new Scene(root, 800, 700);
                stage.setScene(scene);
                stage.show();
            }
        } else if (e.getSource() == addBtn) {

            if (!addArr.getText().equals("") && !addCompany.getText().equals("") && !addDep.getText().equals("") && !addID.getText().equals("") && !addPlane.getText().equals("")) {

                // insert flight given the input data
                FlightDB.getInstance().insertFlight(addID.getText(), addPlane.getText(), addCompany.getText(), addDep.getText(), addArr.getText());

            }


        } else if (e.getSource() == updateBtn) {

            RadioButton radioButton = (RadioButton) group1.getSelectedToggle();
            int option = 0;
            switch (radioButton.getText()) {
                case "company":
                    option = 1;
                    break;
                case "Plane type":
                    option = 2;
                    break;

                default:
                    break;
            }
            // daca am ales optiunea
            if (option > 0) {

                //daca am fields completate
                if (!updateOption.getText().equals("") && !updateID.getText().equals("")) {

                    // updatez liniiile din tabel
                    FlightDB.getInstance().updateFlight(option, updateOption.getText(), updateID.getText());

                }

            }

        } else if (e.getSource() == findBtn) {

            if (!findID.getText().equals("")) {

                FlightDB.getInstance().findFlights(findID.getText());
            }


        } else if (e.getSource() == removeBtn) {
            if (!removeID.getText().equals("")) {
                FlightDB.getInstance().removeFlight(removeID.getText());
            }

        }


    }


    public void onUpdateOption(ActionEvent actionEvent) {
    }
}

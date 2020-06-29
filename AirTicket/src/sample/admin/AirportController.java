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
import org.w3c.dom.Text;
import sample.DB.AirportDB;
import sample.DB.TicketDB;

import java.io.IOException;

public class AirportController {

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
    private TextField addName;
    @FXML
    private TextField addLocation;
    @FXML
    private TextField removeName;
    @FXML
    private TextField updateOption;
    @FXML
    private TextField updateID;
    @FXML
    private TextField findName;
    @FXML
    private ToggleGroup group1;
    @FXML
    private TextField findLocation;

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

            if (!addName.getText().equals("") && !addLocation.getText().equals("")) {

                AirportDB.getInstance().insertAirport(addLocation.getText(), addName.getText());
            }

        } else if (e.getSource() == removeBtn) {

            if (!removeName.getText().equals("")) {

                AirportDB.getInstance().removeAirport(removeName.getText());
            }
        } else if (e.getSource() == updateBtn) {

            RadioButton radioButton = (RadioButton) group1.getSelectedToggle();
            int option = 0;
            switch (radioButton.getText()) {
                case "Location":
                    option = 1;
                    break;
                case "Name":
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
                    AirportDB.getInstance().updateAirport(option, updateOption.getText(), Integer.parseInt(updateID.getText()));

                }


            }
        } else if (e.getSource() == findBtn) {

            if (!findName.getText().equals("") && !findLocation.getText().equals(""))
                AirportDB.getInstance().findAirport(findLocation.getText(), findName.getText());
        }

    }

    public void onUpdateOption(ActionEvent actionEvent) {
    }
}

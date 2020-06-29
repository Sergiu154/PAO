package sample.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Client;
import sample.DB.ClientDB;
import sample.DB.FlightDB;
import sample.DB.TicketDB;

import java.io.IOException;

public class ClientController {

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
    private TextField addEmail;
    @FXML
    private TextField addFirst;
    @FXML
    private TextField addLast;
    @FXML
    private TextField addAge;
    @FXML
    private TextField removeFirst;
    @FXML
    private TextField removeLast;
    @FXML
    private TextField updateFirst;
    @FXML
    private TextField updateLast;
    @FXML
    private TextField updateOption;
    @FXML
    private TextField updateID;
    @FXML
    private Spinner<Integer> ticketsSpinner;
    @FXML
    private TextField findFirst;
    @FXML
    private TextField findLast;

    @FXML
    private ToggleGroup group1;


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
        } else if (e.getSource() == removeBtn) {

            if (!removeFirst.getText().equals("") && !removeLast.getText().equals("")) {
                ClientDB.getInstance().removeClient(removeFirst.getText(), removeLast.getText());
            }


        } else if (e.getSource() == findBtn) {
            if (!findFirst.getText().equals("") && !findLast.getText().equals("")) {


                ClientDB.getInstance().findClient(findFirst.getText(), findLast.getText());

            }


        } else if (e.getSource() == updateBtn) {

            RadioButton radioButton = (RadioButton) group1.getSelectedToggle();
            int option = 0;
            switch (radioButton.getText()) {
                case "First Name":
                    option = 1;
                    break;
                case "Last Name":
                    option = 2;
                    break;
                case "Email":
                    option = 3;
                    break;

                default:
                    break;
            }
            // daca am ales optiunea
            if (option > 0) {

                //daca am fields completate
                if (!updateOption.getText().equals("") && !updateID.getText().equals("")) {

                    // updatez liniiile din tabel
                    ClientDB.getInstance().updateClient(option, updateOption.getText(), Integer.parseInt(updateID.getText()));
                }


            }


        } else if (e.getSource() == addBtn) {
            String first_name = addFirst.getText();
            String last_name = addLast.getText();
            String age = addAge.getText();
            String email = addEmail.getText();
            int spinnerValue = ticketsSpinner.getValue();
            if (!first_name.equals("") && !last_name.equals("") && !age.equals("") && !email.equals("") && spinnerValue > 0) {
                // add client
                ClientDB.getInstance().insertClient(first_name, last_name, age, email, spinnerValue);

            }

        }


    }
}

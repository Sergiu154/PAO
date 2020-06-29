package sample.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    @FXML
    private Button flightBtn;
    @FXML
    private Button airportBtn;
    @FXML
    private Button clientBtn;
    @FXML
    private Button ticketBtn;


    public void onModify(ActionEvent e) throws IOException {

        Stage stage = null;
        Parent root = null;


        if (e.getSource() == flightBtn){
            stage = (Stage) flightBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/admin_scenes/flight_admin_scene.fxml"));

        }
        else if (e.getSource() == airportBtn){
            stage = (Stage) airportBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/admin_scenes/airport_admin_scene.fxml"));


        }
        else if (e.getSource() == clientBtn) {
            stage = (Stage) clientBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/admin_scenes/client_admin_scene.fxml"));

        }
        else if (e.getSource() == ticketBtn) {
            stage = (Stage) ticketBtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/admin_scenes/ticket_admin_scene.fxml"));
        }



        if (root != null && stage != null) {

            Scene scene = new Scene(root, 800, 700);
            stage.setScene(scene);
            stage.show();
        }
    }

}

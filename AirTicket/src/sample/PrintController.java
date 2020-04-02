package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class PrintController {


    private Client client;

    @FXML
    private VBox displayPane;

    @FXML
    private Button backInfo;

    @FXML
    private Button newOrder;

    @FXML
    public void initialize() {

        client = InfoController.getClient();
        Ticket clientTicket = client.getTickets().get(client.getNumOfTickets() - 1);
        client.printTicket(displayPane, clientTicket);

    }

    @FXML
    void onFinalButtons(ActionEvent e) throws IOException {

        Stage stage = null;
        Parent root = null;


        if (e.getSource() == backInfo) {
            stage = (Stage) backInfo.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/scenes/secondScene.fxml"));


        } else {
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
}

package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class FlightController {


    @FXML
    private ToggleButton flightOption0;

    @FXML
    private ToggleButton flightOption1;

    @FXML
    private ToggleButton flightOption2;

    @FXML
    private Button nextButton1;

    @FXML
    private Button backLocation;

    @FXML
    private ToggleGroup t;


    public void onFlightSelected(ActionEvent e) {

        System.out.print("SALUT");

//        if(e.getSource() == flightOption0)
//            flightOption0.setStyle("-fx-background-color: azure;");
//        else if (e.getSource() == flightOption1)
//            flightOption1.setStyle("-fx-background-color: azure;");
//        else if (e.getSource() == flightOption2)
//            flightOption2.setStyle("-fx-background-color: azure;");

    }

    @FXML
    public void initialize() {

        t = new ToggleGroup();
        flightOption1.setToggleGroup(t);
        flightOption0.setToggleGroup(t);
        flightOption2.setToggleGroup(t);
    }

    public void onNextPress(ActionEvent e) throws IOException {


        Stage stage = null;
        Parent root = null;


        if (e.getSource() == nextButton1) {

            ToggleButton btn = (ToggleButton) t.getSelectedToggle();

            if (btn != null) {


                stage = (Stage) nextButton1.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/scenes/secondScene.fxml"));
            }


        } else {
            stage = (Stage) backLocation.getScene().getWindow();
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

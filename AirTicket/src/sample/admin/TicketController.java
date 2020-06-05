package sample.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import sample.DB.TicketDB;
import sample.Ticket;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class TicketController {

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
    private DatePicker addDepDate;
    @FXML
    private DatePicker addArrDate;
    @FXML
    private TextField addDepLoc;
    @FXML
    private TextField addArrLoc;
    @FXML
    private Spinner<Integer> ticketSpinner;

    @FXML
    private ToggleGroup group1;

    @FXML
    private RadioButton ticketNum;

    @FXML
    private RadioButton arrDate;

    @FXML
    private RadioButton depDate;

    @FXML
    private TextField updateOption;
    @FXML
    private TextField ticketID;

    @FXML
    private TextField removeDeparture;

    @FXML
    private TextField findDepLoc;

    @FXML
    private TextField findArrLoc;


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
        }


        // add a ticket in DB
        else if (e.getSource() == addBtn) {
            String arrDate = addArrDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String depDate = addDepDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String arrLoc = addArrLoc.getText();
            String depLoc = addDepLoc.getText();
            int tickets = ticketSpinner.getValue();
            if (!arrDate.equals("") && !depDate.equals("") && !arrLoc.equals("") && !depLoc.equals("") && tickets != 0) {

                TicketDB.getInstance().insertTicket(depDate, arrDate, depLoc, arrLoc, 0);
            }
        }
        // update
        else if (e.getSource() == updateBtn) {

            RadioButton radioButton = (RadioButton) group1.getSelectedToggle();
            int option = 0;
            switch (radioButton.getText()) {
                case "Arr. date":
                    option = 1;
                    break;
                case "Dep. date":
                    option = 2;
                    break;

                default:
                    break;
            }
            // daca am ales optiunea
            if (option > 0) {

                //daca am fields completate
                if (!updateOption.getText().equals("") && !ticketID.getText().equals("")) {

                    // updatez liniiile din tabel
                    TicketDB.getInstance().updateTicket(option, updateOption.getText(), Integer.parseInt(ticketID.getText()));

                }


            }


        }

        //sterge din DB
        else if (e.getSource() == removeBtn) {

            if (!removeDeparture.getText().equals("")) {

                // rempve lines with removeDeparture
                TicketDB.getInstance().removeTicket(removeDeparture.getText());
            }

        } else if (e.getSource() == findBtn) {

            if (!findArrLoc.getText().equals("") && !findDepLoc.getText().equals("")) {

                TicketDB.getInstance().findTickets(findDepLoc.getText(), findArrLoc.getText());
            }

        }


    }

    public void onUpdateOption(ActionEvent actionEvent) {
    }

}

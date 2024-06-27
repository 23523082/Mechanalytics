package project;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
public class ControllerScene2 {

        @FXML
    private Label machineNameLabel;
    
    @FXML
    private Label healthStatusLabel;
    
    @FXML
    private Label temperatureLabel;
    
    @FXML
    private Label ageLabel;

    public void setMachine(Machine machine) {
        machineNameLabel.setText(machine.getMachineName());
        healthStatusLabel.setText(machine.getHealthStatus());
        temperatureLabel.setText(String.valueOf(machine.getTemperature()));
        ageLabel.setText(machine.getAge());
    }

}

package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class FXMLControllerHealth implements Initializable{

    @FXML
    private Label name;
    @FXML
    private Label status;
    @FXML
    private Label temperature;
    @FXML
    private Label age;
    @FXML
    private Label mainPane;
    Machine machine = new Machine("FGK-123", "Decent", 75, "2004/12/2");
    public void setMachine(Machine machine) {
        
        this.machine = machine;
        if (name != null) {
            name.setText("Machine Name: " + machine.getMachineName());
        }
        if (status != null) {
            status.setText("Health Status: " + machine.getHealthStatus());
        }
        if (temperature != null) {
            temperature.setText("Temperature: " + machine.getTemperature()+" Celcius");
        }
        if (age != null) {
            age.setText("Age: " + machine.getAge());
        }
    }

      @FXML
    private void login(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
            Pane page = loader.load();
            FXMLMenuController controller = loader.getController();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("button 2 clicked");
    }

    @FXML
    private void handleButtonAction3(ActionEvent event) {
        System.out.println("button 3 clicked");
    }

    @FXML
    private void handleButtonAction4(ActionEvent event) {
        System.out.println("button 4 clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

   
}


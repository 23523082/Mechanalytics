package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class FXMLMenuController implements Initializable{

    @FXML
    private Label mainPane;

    @FXML
    private void handleButtonAction1(ActionEvent event) {
        System.out.println("button 1 clicked");
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

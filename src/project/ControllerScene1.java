package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane; 
import javafx.scene.layout.Pane;

public class ControllerScene1 implements Initializable {

    private Machine machine;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Label Name;
    @FXML
    private Label Status;
    @FXML
    private Label Age;
    @FXML
    private Label temperature;


    @FXML
    private void login(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSMenu.fxml"));
            Pane page = loader.load();
            FXMLMenuController controller = loader.getController();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane; 
import javafx.scene.layout.Pane;

public class ControllerScene1 implements Initializable {

    @FXML
    private AnchorPane mainPane; 

    @FXML
    private void login(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
            Pane page = loader.load();
            FXMLMenuController controller = loader.getController();
            Machine machine = new Machine("FGK-123", "Decent", 75, "2004/12/2");
            controller.setMachine(machine);

            
            mainPane.getChildren().clear(); 
            mainPane.getChildren().add(page); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
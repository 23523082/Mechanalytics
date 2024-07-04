package project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
public class FXMLControllerHistory implements Initializable {
    @FXML
    private HBox mainPane;
    @FXML
    private void MachineHealth(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
            HBox healthpane = loader.load(); // Load the health pane
            FXMLControllerHealth healthController = loader.getController(); // Get its controller
            // Replace the content of mainPane with the health pane
            mainPane.getChildren().clear();
            mainPane.getChildren().add(healthpane);
            // Optionally pass data to the health controller
            // healthController.setData(someData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception if needed
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHistory.fxml"));
            Pane historyPane = loader.load(); // Load the history pane
            FXMLControllerHistory historyController = loader.getController(); // Get its controller 
            // Replace the content of mainPane with the history pane
            mainPane.getChildren().clear();
            mainPane.getChildren().add(historyPane);
            // Optionally pass data to the history controller
            // historyController.setData(someData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception if needed
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
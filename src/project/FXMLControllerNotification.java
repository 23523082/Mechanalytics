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
import javafx.scene.layout.VBox;
public class FXMLControllerNotification implements Initializable {
    
    @FXML
    private HBox mainPane;

    @FXML
    private VBox Healthpane;

    @FXML
    private VBox historyPane;

    @FXML
    private VBox notificationPane;

    @FXML
    private void MachineHealth(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
            Pane healthPane = loader.load(); // Load the health pane
            FXMLControllerHealth healthController = loader.getController(); // Get its controller
            // Replace the content of mainPane with the health pane
            mainPane.getChildren().clear();
            mainPane.getChildren().add(healthPane);
            // Optionally pass data to the health controller
            // healthController.setData(someData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception if needed
        }
    }
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNotification.fxml"));
            Pane notificationPane = loader.load(); // Load the notification pane
            FXMLControllerNotification notificationController = loader.getController(); // Get its controller
            // Replace the content of mainPane with the notification pane
            mainPane.getChildren().clear();
            mainPane.getChildren().add(notificationPane);
            // Optionally pass data to the notification controller
            // notificationController.setData(someData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception if needed
        }
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

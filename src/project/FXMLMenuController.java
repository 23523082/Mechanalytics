package project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
public class FXMLMenuController implements Initializable {
    
    @FXML
    private HBox mainPane;
    @FXML
    private AnchorPane side_ankerpane;
    @FXML
    private Pane inner_pane;
    @FXML
    private Pane most_inner_pane;
    @FXML
    private Button Healthpane;
    @FXML
    private Button Notification_btn;
    @FXML
    private Button Guide_btn;
    @FXML
    private Button History_btn;
    @FXML
    private void  moveToMachineHealth(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
            HBox healthPane = loader.load(); // Load the health pane
            FXMLControllerHealth controllerHealth = loader.getController(); // Get its controller
            mainPane.getChildren().clear();
            mainPane.getChildren().add(healthPane);
            // Optionally pass data to the health controller
            // healthController.setData(someData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception if needed
        }
    }
    @FXML
    private void MoveToNotification(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNotification.fxml"));
            Pane NotificationPane = loader.load(); // Load the notification pane
            FXMLControllerNotification notificationController = loader.getController(); // Get its controller
            // Replace the content of mainPane with the notification pane
            mainPane.getChildren().clear();
            mainPane.getChildren().add(NotificationPane);
            // Optionally pass data to the notification controller
            // notificationController.setData(someData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception if needed
        }
    }
    @FXML
    private void MoveToGuide(ActionEvent event) {
        System.out.println("button 3 clicked");
    }
    @FXML
    private void MoveToHistory(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHistory.fxml"));
            Pane HistoryPane = loader.load(); // Load the history pane
            FXMLControllerHistory historyController = loader.getController(); // Get its controller 
            // Replace the content of mainPane with the history pane
            mainPane.getChildren().clear();
            mainPane.getChildren().add(HistoryPane);
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
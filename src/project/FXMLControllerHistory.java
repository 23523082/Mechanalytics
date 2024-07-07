package project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
public class FXMLControllerHistory implements Initializable {

    @FXML
    private HBox HistoryPane;

 @FXML
    private void  moveToMachineHealth(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
            HBox Healthpane = loader.load(); // Load the health pane
            FXMLControllerHealth controllerHealth = loader.getController(); // Get its controller
            HistoryPane.getChildren().clear();
            HistoryPane.getChildren().add(Healthpane);
            // Optionally pass data to the health controller
            // healthController.setData(someData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception if needed
        }
    }
       @FXML
    void MoveToGuide(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGuide.fxml"));
            HBox GuidePane = loader.load(); // Load the health pane
            FXMLControllerGuide FXMLGUIDENS = loader.getController(); // Get its controller
            // Replace the content of mainPane with the health pane
            HistoryPane.getChildren().clear();
            HistoryPane.getChildren().add(GuidePane);
            // Optionally pass data to the health controller
            // healthController.setData(someData);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception if needed
        }
    }

    @FXML
    void MoveToHistory(ActionEvent event) {
        try {
        // Correct the resource path to point to FXMLHistory.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHistory.fxml"));
        // Load the history pane, assuming it's also an HBox or adjust as necessary
        HBox HistoryPane = loader.load();

        // Clear the Healthpane and add the history pane to it
        HistoryPane.getChildren().clear();
        HistoryPane.getChildren().add(HistoryPane);

        // Optionally, if you need to interact with the History controller
        // FXMLControllerHistory historyController = loader.getController();
        // historyController.setData(someData); // Pass data if needed
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception
    }
    }

    @FXML
    void MoveToMenu(MouseEvent event) {
        try {
        // Correct the resource path to point to FXMLHistory.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSMenu.fxml"));
        // Load the history pane, assuming it's also an HBox or adjust as necessary
        HBox mainPane = loader.load();

        // Clear the Healthpane and add the history pane to it
        HistoryPane.getChildren().clear();
        HistoryPane.getChildren().add(mainPane);

        // Optionally, if you need to interact with the History controller
        // FXMLControllerHistory historyController = loader.getController();
        // historyController.setData(someData); // Pass data if needed
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception
    }
    }

    @FXML
    void MoveToNotification(ActionEvent event) {
        try {
        // Correct the resource path to point to FXMLHistory.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNotification.fxml"));
        // Load the history pane, assuming it's also an HBox or adjust as necessary
        HBox NotificationPane = loader.load();

        // Clear the Healthpane and add the history pane to it
        HistoryPane.getChildren().clear();
        HistoryPane.getChildren().add(NotificationPane);

        // Optionally, if you need to interact with the History controller
        // FXMLControllerHistory historyController = loader.getController();
        // historyController.setData(someData); // Pass data if needed
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
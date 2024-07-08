package project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
public class FXMLControllerNotification implements Initializable {
    
    @FXML
    private HBox NotificationPane;

    @FXML
    private HBox Healthpane;

    @FXML
    private VBox historyPane;

    @FXML
    private VBox notificationPane;

    

     @FXML
    private void  moveToMachineHealth(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
            HBox Healthpane = loader.load(); // Load the health pane
            NotificationPane.getChildren().clear();
            NotificationPane.getChildren().add(Healthpane);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
       @FXML
    void MoveToGuide(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGuide.fxml"));
            HBox GuidePane = loader.load(); 
            NotificationPane.getChildren().clear();
            NotificationPane.getChildren().add(GuidePane);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    @FXML
    void MoveToHistory(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHistory.fxml"));
        HBox HistoryPane = loader.load();
        NotificationPane.getChildren().clear();
        NotificationPane.getChildren().add(HistoryPane);

        
    } catch (IOException e) {
        e.printStackTrace(); 
    }}

    @FXML
    void MoveToMenu(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSMenu.fxml"));
        HBox mainPane = loader.load();

        NotificationPane.getChildren().clear();
        NotificationPane.getChildren().add(mainPane);

    } catch (IOException e) {
        e.printStackTrace(); 
    }}

    @FXML
    void MoveToNotification(ActionEvent event) {
        try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNotification.fxml"));
        HBox NotificationPane = loader.load();
        NotificationPane.getChildren().clear();
        NotificationPane.getChildren().add(NotificationPane);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

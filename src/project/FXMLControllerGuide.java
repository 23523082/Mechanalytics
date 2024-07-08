package project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FXMLControllerGuide implements Initializable {

    @FXML
    private HBox GuidePane;

    @FXML
    private Button Guide_btn;

    @FXML
    private Button Healthpane;

    @FXML
    private Button History_btn;

    @FXML
    private ImageView MoveToMenu_btn;

    @FXML
    private Button Notification_btn;

    @FXML
    private Pane inner_pane;

    @FXML
    private Pane most_inner_pane;

    @FXML
    private AnchorPane side_ankerpane;

     @FXML
    private void  moveToMachineHealth(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
            HBox Healthpane = loader.load(); 
            GuidePane.getChildren().clear();
            GuidePane.getChildren().add(Healthpane);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
       @FXML
    void MoveToGuide(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGuide.fxml"));
            HBox GuidePane = loader.load(); 
            GuidePane.getChildren().clear();
            GuidePane.getChildren().add(GuidePane);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    @FXML
    void MoveToHistory(ActionEvent event) {
        try {
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHistory.fxml"));
        HBox HistoryPane = loader.load();
        GuidePane.getChildren().clear();
        GuidePane.getChildren().add(HistoryPane);
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    }

    @FXML
    void MoveToMenu(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSMenu.fxml"));
        HBox mainPane = loader.load();

        GuidePane.getChildren().clear();
        GuidePane.getChildren().add(mainPane);

    } catch (IOException e) {
        e.printStackTrace(); 
    }
    }

    @FXML
    void MoveToNotification(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNotification.fxml"));
        HBox NotificationPane = loader.load();

        
        GuidePane.getChildren().clear();
        GuidePane.getChildren().add(NotificationPane);

        
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

package project;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FXMLControllerHistory implements Initializable {
    @FXML
    private HBox mainPane;
    @FXML
    private HBox HistoryPane;
    @FXML
    private AnchorPane side_ankerpane;
    @FXML
    private Pane inner_pane;
    @FXML
    private Pane most_inner_pane;
    @FXML
    private Button MachineHealth;
    @FXML
    private Button Notification_btn;
    @FXML
    private Button Guide_btn;
    @FXML
    private Button History_btn;
    @FXML
    private AnchorPane TheHistory_Pane;
    @FXML
    private TableView<MachineHistory> History_TableView;
    @FXML
    private TableColumn<MachineHistory, String> date_Machine_History;
    @FXML
    private TableColumn<MachineHistory, String> UserName_Machine_History;
    @FXML
    private TableColumn<MachineHistory, String> MachineName_Machine_History;
    @FXML
    private TableColumn<MachineHistory, String> MachineBrand_Machine_History;
    @FXML
    private TableColumn<MachineHistory, String> IssueType_Machine_History;
    @FXML
    private TableColumn<MachineHistory, String> Description_Machine_History;
    @FXML
    private TableColumn<MachineHistory, String> Status_Machine_History;
    @FXML
    private TextField history_search;
    @FXML
    private TextField InsertDescription_IssueMachine;
    @FXML
    private Button AddNewNote_IssueMachine;
    @FXML
    private Button DeleteNote_IssueMachine;
    @FXML
    private Button SubmitNote_IssueMachine;
    @FXML
    private TextField addUserName_IssueMachine;
    @FXML
    private TextField addMachineBrand_IssueMachine;
    @FXML
    private ComboBox<?> ChooseMachine_IssueMachine;
    @FXML
    private ComboBox<?> addIssueType_IssueMachine;

    @FXML
    void MoveToGuide(ActionEvent event) {

    }

    @FXML
    void MoveToHistory(ActionEvent event) {

    }

    @FXML
    void MoveToNotification(ActionEvent event) {

    }

    @FXML
    private void MachineHealth(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
            HBox healthpane = loader.load(); 
            FXMLControllerHealth healthController = loader.getController(); 
            
            mainPane.getChildren().clear();
            mainPane.getChildren().add(healthpane);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }


    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<MachineHistory> historyList = DataMachineHistory.loadMachineHistoryFromXML("machineHistory.xml");
        if (historyList != null) {
            System.out.println("Loaded " + historyList.size() + " entries from XML.");
            for (MachineHistory history : historyList) {
                System.out.println(history);
            }
            History_TableView.getItems().addAll(historyList);
        } else {
            System.out.println("Failed to load data from XML.");
        }
}}


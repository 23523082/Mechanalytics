package project;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FXMLControllerHistory implements Initializable {

    @FXML
    private HBox HistoryPane;
    @FXML
    private AnchorPane side_ankerpane;
    @FXML
    private Pane inner_pane;
    @FXML
    private ImageView MoveToMenu_btn;
    @FXML
    private Pane most_inner_pane;
    @FXML
    private Button Health_btn;
    @FXML
    private Button Notification_btn;
    @FXML
    private Button Guide_btn;
    @FXML
    private Button History_btn;
    @FXML
    private AnchorPane TheHistory_Pane;
    @FXML
    private TableView<MachineHistory> HistoryTableView;
    @FXML
    private TableColumn<MachineHistory, String> date;
    @FXML
    private TableColumn<MachineHistory, String> UserName;
    @FXML
    private TableColumn<MachineHistory, String> MachineName;
    @FXML
    private TableColumn<MachineHistory, String> MachineBrand;
    @FXML
    private TableColumn<MachineHistory, String> IssueType;
    @FXML
    private TableColumn<MachineHistory, String> Description;
    @FXML
    private TableColumn<MachineHistory, String> Status;
    @FXML
    private TextField history_search;

    @FXML
    private TextField TextDescription;

    @FXML
    private Button DeleteNote_IssueMachine;

    @FXML
    private Button SubmitNote_IssueMachine;

    @FXML
    private TextField Textdate;

    @FXML
    private TextField TextSubmitter;

    @FXML
    private TextField TextMachineBrand;

    @FXML
    private TextField TextIssueType;

    @FXML
    private TextField TextChooseMachine;

    @FXML
    void MoveToGuide(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGuide.fxml"));
            HBox GuidePane = loader.load(); 
            HistoryPane.getChildren().clear();
            HistoryPane.getChildren().add(GuidePane);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    @FXML
    void MoveToHistory(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHistory.fxml"));
        HBox HistoryPane = loader.load();
        HistoryPane.getChildren().clear();
        HistoryPane.getChildren().add(HistoryPane);
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    }

    @FXML
    void MoveToMenu(MouseEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSMenu.fxml"));
        HBox mainPane = loader.load();
       HistoryPane.getChildren().clear();
        HistoryPane.getChildren().add(mainPane);
    } catch (IOException e) {
        e.printStackTrace(); 
    }}

    @FXML
    void MoveToNotification(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNotification.fxml"));
        HBox NotificationPane = loader.load();
        HistoryPane.getChildren().clear();
        HistoryPane.getChildren().add(NotificationPane);  
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    }

    @FXML
    void moveToMachineHealth(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
            HBox healthpane = loader.load(); 
           
            
            HistoryPane.getChildren().clear();
            HistoryPane.getChildren().add(healthpane);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }


    

    @FXML
    private void submitMachineHistory(ActionEvent event) {
        String date = Textdate.getText();
        String submitter = TextSubmitter.getText();
        String machineName = TextChooseMachine.getText();
        String machineBrand = TextMachineBrand.getText();
        String issueType = TextIssueType.getText();
        String description = TextDescription.getText();
    
        if (date.isEmpty() || submitter.isEmpty() || machineName.isEmpty() || machineBrand.isEmpty() || issueType.isEmpty() || description.isEmpty()) {
            System.out.println("Please fill in all fields");
            return;
        }
    
        MachineHistory newEntry = new MachineHistory(
            date,
            submitter,
            machineName,
            machineBrand,
            issueType,
            description,
            "Pending"
        );
    
        List<MachineHistory> historyList = DataMachineHistory.loadMachineHistoryFromXML("MachineHistory.xml");
        if (historyList == null) {
            historyList = new ArrayList<>();
        }
    
        historyList.add(newEntry);
        DataMachineHistory.saveMachineHistoryToXML("MachineHistory.xml", historyList);
        HistoryTableView.getItems().clear();
        HistoryTableView.getItems().addAll(historyList);
    
        // Clear the text fields
        Textdate.clear();
        TextSubmitter.clear();
        TextChooseMachine.clear();
        TextMachineBrand.clear();
        TextIssueType.clear();
        TextDescription.clear();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

         date.setCellValueFactory(new PropertyValueFactory<>("date"));
        UserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        MachineName.setCellValueFactory(new PropertyValueFactory<>("machineName"));
        MachineBrand.setCellValueFactory(new PropertyValueFactory<>("machineBrand"));
        IssueType.setCellValueFactory(new PropertyValueFactory<>("issueType"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        Status.setCellValueFactory(new PropertyValueFactory<>("status"));

        List<MachineHistory> historyList = DataMachineHistory.loadMachineHistoryFromXML("machineHistory.xml");
        if (historyList != null) {
            System.out.println("Loaded " + historyList.size() + " entries from XML.");
            for (MachineHistory history : historyList) {
                System.out.println(history);
            }

            HistoryTableView.getItems().addAll(historyList);

        } else {
            System.out.println("Failed to load data from XML.");
        }
        

}}


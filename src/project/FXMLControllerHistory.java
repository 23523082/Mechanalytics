package project;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
<<<<<<< HEAD
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
=======
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
>>>>>>> 191fcdd4a5637b9933d3d1c436a1207e5bc95147
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FXMLControllerHistory implements Initializable {
<<<<<<< HEAD
   
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
    private TableView<MachineHistory> HistoryTableView;
    @FXML
    private TableColumn<MachineHistory, List<MachineHistory>> date;
    @FXML
    private TableColumn<MachineHistory, List<MachineHistory>> UserName;
    @FXML
    private TableColumn<MachineHistory, List<MachineHistory>> MachineName;
    @FXML
    private TableColumn<MachineHistory, List<MachineHistory>> MachineBrand;
    @FXML
    private TableColumn<MachineHistory, List<MachineHistory>> IssueType;
    @FXML
    private TableColumn<MachineHistory, List<MachineHistory>> Description;
    @FXML
    private TableColumn<MachineHistory, List<MachineHistory>> Status;
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
    private ComboBox<Machine> choose;
    @FXML
    private TextField TextMachineBrand;
    @FXML
    private TextField TextIssueType;


=======

    @FXML
    private HBox HistoryPane;
>>>>>>> 191fcdd4a5637b9933d3d1c436a1207e5bc95147

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

    @FXML
    void moveToMachineHealth(ActionEvent event) {
        try {
<<<<<<< HEAD
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
            HBox healthpane = loader.load(); 
            FXMLControllerHealth healthController = loader.getController(); 
            
            HistoryPane.getChildren().clear();
            HistoryPane.getChildren().add(healthpane);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    @FXML
    private void machineName(ActionEvent event) {
        List<String> machines = DataMachine.getAllMachineNames("Machine.xml");

    if (machines != null && !machines.isEmpty()) {
        choose.getItems().clear(); // Clear existing items
        List<Machine> machineList = new ArrayList<>();
        for (String machineName : machines) {
            Machine machine = new Machine(machineName, null, null, null, null); 
            machineList.add(machine);
        }
        ObservableList<Machine> observableMachines = FXCollections.observableArrayList(machineList);
        choose.setItems(observableMachines); // Use setItems instead of getItems
    } else {
        System.out.println("No machines found in the XML file.");
    }
}

    

    @FXML
    private void submitMachineHistory(ActionEvent event) {
         // Gather data from text fields
    String date = Textdate.getText();
    String submitter = TextSubmitter.getText();
    String machineBrand = TextMachineBrand.getText();
    String issueType = TextIssueType.getText();
    
    // Get selected machine
    Machine selectedMachine = choose.getSelectionModel().getSelectedItem();
    
    if (selectedMachine != null) {
        // Create new MachineHistory entry
        MachineHistory newEntry = new MachineHistory(
            date,
            submitter,
            selectedMachine.getMachineName(),
            machineBrand,
            issueType,
            "",
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
    } else {
        System.out.println("No machine selected");
    }
}

    

    


    
=======
        // Correct the resource path to point to FXMLHistory.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
        // Load the history pane, assuming it's also an HBox or adjust as necessary
        HBox Healthpane = loader.load();

        // Clear the Healthpane and add the history pane to it
        HistoryPane.getChildren().clear();
        HistoryPane.getChildren().add(Healthpane);

        // Optionally, if you need to interact with the History controller
        // FXMLControllerHistory historyController = loader.getController();
        // historyController.setData(someData); // Pass data if needed
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception
    }
    }
>>>>>>> 191fcdd4a5637b9933d3d1c436a1207e5bc95147
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
<<<<<<< HEAD
            HistoryTableView.getItems().addAll(historyList);
=======
>>>>>>> 191fcdd4a5637b9933d3d1c436a1207e5bc95147
        } else {
            System.out.println("Failed to load data from XML.");
        }
        

}}


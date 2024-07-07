package project;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FXMLControllerHealth implements Initializable {

    @FXML
    private HBox Healthpane;
    @FXML
    private AnchorPane side_ankerpane;
    @FXML
    private Pane inner_pane;
    @FXML
    private Pane most_inner_pane;
    @FXML
    private Button Notification_btn;
    @FXML
    private Button Guide_btn;
    @FXML
    private Button History_btn;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private Label name;
    @FXML
    private Label status;
    @FXML
    private Label temperature;
    @FXML
    private Label age;
    @FXML
    private Label moduleseries;
    @FXML
    private Label modulehealth;
    @FXML
    private Label modulecurrent;
    @FXML
    private LineChart<String, Number> modulechart;
    @FXML
    private CategoryAxis xAxis1;
    @FXML
    private NumberAxis yAxis1;

   @FXML
    void MoveToGuide(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGuide.fxml"));
            HBox GuidePane = loader.load(); // Load the health pane
            FXMLControllerGuide FXMLGUIDENS = loader.getController(); // Get its controller
            // Replace the content of mainPane with the health pane
            Healthpane.getChildren().clear();
            Healthpane.getChildren().add(GuidePane);
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
        Healthpane.getChildren().clear();
        Healthpane.getChildren().add(HistoryPane);

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
        Healthpane.getChildren().clear();
        Healthpane.getChildren().add(mainPane);

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
        Healthpane.getChildren().clear();
        Healthpane.getChildren().add(NotificationPane);

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
        // Correct the resource path to point to FXMLHistory.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSHealth.fxml"));
        // Load the history pane, assuming it's also an HBox or adjust as necessary
        HBox Healthpane = loader.load();

        // Clear the Healthpane and add the history pane to it
        Healthpane.getChildren().clear();
        Healthpane.getChildren().add(Healthpane);

        // Optionally, if you need to interact with the History controller
        // FXMLControllerHistory historyController = loader.getController();
        // historyController.setData(someData); // Pass data if needed
    } catch (IOException e) {
        e.printStackTrace(); // Handle the exception
    }
    }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDataFromXML();
        initializeChart();
    }

    private void loadDataFromXML() {
        XStream xStream = new XStream();
        XStream moduleStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY); // Allow all types (use with caution)
        xStream.alias("machine", Machine.class);
        moduleStream.addPermission(AnyTypePermission.ANY);
        moduleStream.alias("module", Module.class);

        try (FileReader reader = new FileReader("machine.xml")) {
            Machine loadedMachine = (Machine) xStream.fromXML(reader);

            // Display data in labels
            
            name.setText(loadedMachine.getMachineName());
            status.setText(loadedMachine.getHealthStatus());
            temperature.setText(loadedMachine.getTemperature());
            age.setText(loadedMachine.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader reader = new FileReader("module.xml")) {
            Module loadedModule = (Module) moduleStream.fromXML(reader);

            // Display data in labels
            
            moduleseries.setText(loadedModule.getModuleSeries());
            modulehealth.setText(loadedModule.getModuleHealth());
            modulecurrent.setText(loadedModule.getModuleCurrent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeChart() {
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Performance Index");
        series1.getData().add(new XYChart.Data<>("Jan", 23));
        series1.getData().add(new XYChart.Data<>("Feb", 14));
        series1.getData().add(new XYChart.Data<>("Mar", 15));
        series1.getData().add(new XYChart.Data<>("Apr", 24));
        series1.getData().add(new XYChart.Data<>("May", 34));
        series1.getData().add(new XYChart.Data<>("Jun", 36));
        series1.getData().add(new XYChart.Data<>("Jul", 22));
        series1.getData().add(new XYChart.Data<>("Aug", 45));
        series1.getData().add(new XYChart.Data<>("Sep", 43));
        series1.getData().add(new XYChart.Data<>("Oct", 17));
        series1.getData().add(new XYChart.Data<>("Nov", 29));
        series1.getData().add(new XYChart.Data<>("Dec", 25));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Module Health Index");
        series2.getData().add(new XYChart.Data<>("Jan", 33));
        series2.getData().add(new XYChart.Data<>("Feb", 34));
        series2.getData().add(new XYChart.Data<>("Mar", 37));
        series2.getData().add(new XYChart.Data<>("Apr", 45));
        series2.getData().add(new XYChart.Data<>("May", 35));
        series2.getData().add(new XYChart.Data<>("Jun", 30));
        series2.getData().add(new XYChart.Data<>("Jul", 38));
        series2.getData().add(new XYChart.Data<>("Aug", 41));
        series2.getData().add(new XYChart.Data<>("Sep", 33));
        series2.getData().add(new XYChart.Data<>("Oct", 32));
        series2.getData().add(new XYChart.Data<>("Nov", 38));
        series2.getData().add(new XYChart.Data<>("Dec", 37));

        lineChart.getData().addAll(series1);
        modulechart.getData().addAll(series2);
    }

    
    
}

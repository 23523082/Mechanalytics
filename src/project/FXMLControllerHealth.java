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
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button btn_Menu4;
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
    void history(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLHistory.fxml"));
            HBox historyPane = loader.load(); 
            FXMLControllerHistory historyController = loader.getController(); // Get its controller 
            Healthpane.getChildren().clear();
            Healthpane.getChildren().add(historyPane);
            // Optionally pass data to the history controller
            // historyController.setData(someData);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
    @FXML
    void handleButtonAction4(ActionEvent event) {
        // Button action code here
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

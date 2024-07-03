package project;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class FXMLControllerHealth implements Initializable{
 @FXML
    private HBox Healthpane;

    @FXML
    private AnchorPane side_ankerpane;

    @FXML
    private Pane inner_pane;

    @FXML
    private Pane most_inner_pane;

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Label ModuleName;

    @FXML
    private Label name;

    @FXML
    private Label status;

    @FXML
    private Label temperature;

    @FXML
    private Label age;






    
    // @FXML
    // private HBox Healthpane;
    // @FXML
    // private Label name;
    // @FXML
    // private Label status;
    // @FXML
    // private Label temperature;
    // @FXML
    // private Label age;
    // @FXML
    // private Label mainPane;
    // @FXML
    // private LineChart<String, Number> lineChart;
    
    


    
  
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Perfomance Index");
        
        series1.getData().add(new XYChart.Data("Jan", 23));
        series1.getData().add(new XYChart.Data("Feb", 14));
        series1.getData().add(new XYChart.Data("Mar", 15));
        series1.getData().add(new XYChart.Data("Apr", 24));
        series1.getData().add(new XYChart.Data("May", 34));
        series1.getData().add(new XYChart.Data("Jun", 36));
        series1.getData().add(new XYChart.Data("Jul", 22));
        series1.getData().add(new XYChart.Data("Aug", 45));
        series1.getData().add(new XYChart.Data("Sep", 43));
        series1.getData().add(new XYChart.Data("Oct", 17));
        series1.getData().add(new XYChart.Data("Nov", 29));
        series1.getData().add(new XYChart.Data("Dec", 25));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Portfolio 2");
        series2.getData().add(new XYChart.Data("Jan", 33));
        series2.getData().add(new XYChart.Data("Feb", 34));
        series2.getData().add(new XYChart.Data("Mar", 25));
        series2.getData().add(new XYChart.Data("Apr", 44));
        series2.getData().add(new XYChart.Data("May", 39));
        series2.getData().add(new XYChart.Data("Jun", 16));
        series2.getData().add(new XYChart.Data("Jul", 55));
        series2.getData().add(new XYChart.Data("Aug", 54));
        series2.getData().add(new XYChart.Data("Sep", 48));
        series2.getData().add(new XYChart.Data("Oct", 27));
        series2.getData().add(new XYChart.Data("Nov", 37));
        series2.getData().add(new XYChart.Data("Dec", 29)); 
              
        lineChart.getData().addAll(series1);

        try (FileReader reader = new FileReader("machine.xml")) {
            XStream xStream = new XStream();
            xStream.alias("machine", Machine.class);
            Machine loadedMachine = (Machine) xStream.fromXML(reader);

            // Display data in labels
            ModuleName.setText("Machine Data");
            name.setText(loadedMachine.getMachineName());
            status.setText(loadedMachine.getHealthStatus());
            temperature.setText(loadedMachine.getTemperature());
            age.setText(loadedMachine.getAge());

            // Example of loading chart data (assuming you have implemented this part)
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    }

   



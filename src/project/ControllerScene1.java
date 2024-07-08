package project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane; 
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ControllerScene1 implements Initializable {

     @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField usernameField; // Assuming the FXML ID is usernameField
    @FXML
    private PasswordField passwordField; // Assuming the FXML ID is passwordField

    @FXML
    private void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("1".equals(username) && "2".equals(password)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSMenu.fxml"));
                Pane page = loader.load();
                Scene scene = new Scene(page);
                Stage stage = (Stage) mainPane.getScene().getWindow();
                stage.setScene(scene);
                stage.sizeToScene();
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Here you can handle the incorrect credentials case
            // For example, show an error message to the user
            System.out.println("Incorrect username or password.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
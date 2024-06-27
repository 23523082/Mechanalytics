package project;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.net.URL;

public class OpenScene {
    private Pane page;
    
    public Pane getPane(String fileName) {

        try {
            URL pageFile = SceneRunner.class.getResource("/project/"+ fileName + ".fxml" );
            
            if (pageFile == null) {
                throw new java.io.FileNotFoundException("cannot find what you seek");
            }

            page = FXMLLoader.load(pageFile);
        } catch (Exception e) {
            System.out.println("Cannot find what you seek.");
        }
        return page;
    }

    
    
}

package com.jfx.pos.config;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Reza
 */
public class AppMain extends Application {
    
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new GetStart(primaryStage, "Authentication.fxml", "authentication.css", "");
    }

    class GetStart extends JFXController {

         @Override
        public void initialize(Object paramObject) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        public GetStart(Stage STAGE, String FXML, String CSS, String TITLE){
            this.launch(STAGE, FXML, CSS, TITLE);
        }

    }

}

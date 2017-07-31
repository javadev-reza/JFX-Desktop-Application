package com.jfx.pos.config;

import com.jfx.library.component.JFXComponent;
import com.jfx.library.constant.Constants.PATH;
import java.io.IOException;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Reza
 * @param <Class>
 * @param <T>
 */
public abstract class JFXController<Class, T> extends JFXComponent {
    
    /**
     * Instance Spring Context
     */
    public static final ApplicationContext applicationContext = 
           new AnnotationConfigApplicationContext(AppConfig.class);
    
    /**
     * @param paramObject
     */
    public abstract void initialize(Object paramObject);
    
    /**
     * @param URL : new String();
     * @return    : new HashMap<>();
     */
    private Map load(String URL) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(clazz -> applicationContext.getBean(clazz));
            loader.setLocation(getClass().getResource(URL));
            setResult("loader", loader.load());
            setResult("controller", loader.getController());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResult();
    }

    /**
     * @param STAGE : new String();
     * @param FXML  : new String();
     * @param CSS   : new String();
     * @param TITLE : new String();
     */
    public void launch(Stage STAGE, String FXML, String CSS, String TITLE){
        try{
            Map<String, Object> result = this.load(PATH.FXML+FXML);
            Parent root = (Parent) result.get("loader");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(PATH.STYLES+CSS);
            //STAGE.initStyle(StageStyle.UTILITY);
            STAGE.setMaximized(true);
            STAGE.setTitle(TITLE);
            STAGE.setScene(scene);  
            STAGE.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * @param FXML  : new String();
     * @param CSS   : new String();
     * @param TITLE : new String();
     * @return      : new Object();
     */
    public T setVisible(String FXML, String CSS, String TITLE){
        try{
            Map<String, Object> result = this.load(PATH.FXML+FXML);
            //---------------------------
            Parent root = (Parent) result.get("loader");
            setResult("controller", result.get("controller"));
            //---------------------------
            Scene scene = new Scene(root);
            scene.getStylesheets().add(PATH.STYLES+CSS);
            //---------------------------
            Stage stage = new Stage();
            stage.initModality(Modality.NONE);
            stage.initStyle(StageStyle.UNIFIED);
            stage.setMaximized(true);
            stage.setTitle(TITLE);
            stage.setScene(scene);
            stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return (T) getResult().get("controller");
    }
    
    /**
     * @param FXML  : new String();
     * @param CSS   : new String();
     * @return      : new Object();
     */
    public T setVisible(String FXML, String CSS){
        try{
            Map<String, Object> result = this.load(PATH.FXML+FXML);
            //---------------------------
            Parent root = (Parent) result.get("loader");
            setResult("controller", result.get("controller"));
            //---------------------------
            Scene scene = new Scene(root);
            scene.getStylesheets().add(PATH.STYLES+CSS);
            //---------------------------
            Stage stage = new Stage();
            stage.initModality(Modality.NONE);
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(scene);
            stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return (T) getResult().get("controller");
    }
    
    /**
     * @param FXML  : new String();
     * @param CSS   : new String();
     * @return      : new Object();
     */
    public AnchorPane setRootVisible(String FXML, String CSS){
        Map<String, Object> result = this.load(PATH.FXML+FXML);
        return (AnchorPane)result.get("loader");
    }
    
    /**
     * @param event
     */
    public void closeWindow(ActionEvent event){
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}

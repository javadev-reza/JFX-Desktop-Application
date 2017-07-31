package com.jfx.pos.controller;

import com.jfx.library.component.Items;
import com.jfx.pos.config.JFXController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Controller;

@Controller
public class Employee_Add extends JFXController {
 
    @FXML
    private Accordion accordionaddress;
    
     @FXML
    private TitledPane accordionuser;
    
    @FXML
    private ImageView image;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField identitynumber;
    
    @FXML
    private TextArea address;

    @FXML
    private TextField postalcode;

    @FXML
    private TextField phonenumber;

    @FXML
    private TextField email;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button browse;

    @FXML
    private Button personalsave;

    @FXML
    private Button personalupdate;

    @FXML
    private Button personalclear;
    
    @FXML
    private Button usersave;

    @FXML
    private Button userclear;
    
     @FXML
    private TreeView<?> moduls;

    @FXML
    private TreeView<?> applications;
    
    @FXML
    private ListView<Items> province;

    @FXML
    private TreeView<?> countytown;

    @FXML
    private TreeView<?> district;
    

    @Override
    public void initialize(Object paramObject) {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", 1);
        map1.put("name", "papua 1");
        data.add(map1);
        
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 2);
        map2.put("name", "papua 2");
        data.add(map2);
        
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", 3);
        map3.put("name", "papua 3");
        data.add(map3);
        
        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", 4);
        map4.put("name", "papua 4");
        data.add(map4);
        
        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", 5);
        map5.put("name", "papua 5");
        data.add(map5);
        
        Map<String, Object> map6 = new HashMap<>();
        map6.put("id", 6);
        map6.put("name", "papua 6");
        data.add(map6);
        
        setListView(province, data);
    }

    @FXML
    void browseAction(ActionEvent event) {
        
    }

    @FXML
    void personalClearAction(ActionEvent event) {
        
    }

    @FXML
    void personalSaveAction(ActionEvent event) {
        
    }

    @FXML
    void personalUpdateAction(ActionEvent event) {
        
    }
    
    @FXML
    void provinceAction(ActionEvent event) {

    }

    @FXML
    void userClearAction(ActionEvent event) {
        
    }

    @FXML
    void userSaveAction(ActionEvent event) {
        
    }
}

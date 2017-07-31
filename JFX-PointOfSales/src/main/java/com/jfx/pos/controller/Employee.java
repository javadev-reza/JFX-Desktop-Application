package com.jfx.pos.controller;

import com.jfx.pos.config.JFXController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

@Controller
public class Employee extends JFXController {

    public String easdsd;
    
     @FXML
    public TableView<?> tableEmployee;

    @FXML
    public Pagination paggingEmployee;

    @FXML
    public Button add;

    @FXML
    private Button detail;

    @FXML
    public TextField searchEmployee;

    @FXML
    private Button search;
    
    @Override
    public void initialize(Object paramObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    void addAction(ActionEvent event) {
        Employee_Add controller = (Employee_Add)setVisible("EmployeeAdd.fxml", "employeeadd.css");
        controller.initialize(Employee.this);
    }

    @FXML
    void detailAction(ActionEvent event) {

    }

    @FXML
    void searchAction(ActionEvent event) {

    }
}

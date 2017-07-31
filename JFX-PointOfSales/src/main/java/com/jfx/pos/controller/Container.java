package com.jfx.pos.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfx.pos.config.JFXController;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Controller;

@Controller
public class Container extends JFXController {
    
    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private JFXDrawer sideMenuDrawer;
    
    @FXML
    private ScrollPane container;

    @Override
    public void initialize(Object paramObject) {
        setSideBarMenu(hamburger, sideMenuDrawer);
        setToContainer(container, (AnchorPane) setRootVisible("Employee.fxml", "employee.css"));
    }
}

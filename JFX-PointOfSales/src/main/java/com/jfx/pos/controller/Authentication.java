package com.jfx.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfx.business.service.AuthenticateService;
import com.jfx.library.util.CommonUtil;
import com.jfx.pos.config.JFXController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Authentication extends JFXController {
    
    @Autowired
    private AuthenticateService authenticateService;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private JFXButton login;
    
    @FXML
    private JFXProgressBar progressbar;
    
    @FXML
    private Label forgotpassword;
    
    @Override
    public void initialize(Object paramObject) {}

    @FXML
    public void LoginAction(ActionEvent event) {
        new Thread(){
            @Override
            public void run(){
                setDisableComponent(true);
                setContainer(authenticateService.authenticate(username.getText(), password.getText()));
            }
        }.start();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), ev -> {
            if(CommonUtil.isNotNullOrEmpty(getContainer())){
                if((Boolean)getContainer().get("auth")){
                    Container controller = (Container) setVisible("Container.fxml", "container.css", "Information System");
                    controller.initialize(null);
                    closeWindow(event);
                } else{
                    setDisableComponent(false);
                    JOptionPane.showMessageDialog(null, getContainer().get("message"));
                }
            }
        }));
        timeline.play();
    }
    
    @FXML
    public void forgotPasswordAction() {
        new Thread(){
            @Override
            public void run(){
                setDisableComponent(true);
            }
        }.start();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), ev -> {
            setDisableComponent(false);
        }));
        timeline.play();
    }
    
    public void setDisableComponent(Boolean flag){
        progressbar.setVisible(flag);
        if(flag){
            login.setDisable(true);
            forgotpassword.setDisable(true);
        } else{
            login.setDisable(false);
            forgotpassword.setDisable(false);
        }
    }

}

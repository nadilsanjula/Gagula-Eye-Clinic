package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginScreenController {

    @FXML
    private AnchorPane loginPane;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXTextField usrnmeField;

    @FXML
    private JFXPasswordField passwrdField;

    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/userDashboard.fxml"));
        loginPane.getChildren().clear();
        loginPane.getChildren().add(load);
        
    }
}

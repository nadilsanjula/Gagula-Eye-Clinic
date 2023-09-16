package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
        String username = usrnmeField.getText();
        String password = passwrdField.getText();

        // Check for user role based on username
        if ("user".equals(username)) {
            // User role
            String validUserPassword = "user1234";

            if (password.equals(validUserPassword)) {
                // Username and password are correct for the user role, proceed to userDashboard
                loadDashboard("/view/userDashboard.fxml");
                return; // Exit the method
            }
        } else if ("doctor".equals(username)) {
            // Doctor role
            String validDoctorPassword = "doctor1234";

            if (password.equals(validDoctorPassword)) {
                // Username and password are correct for the doctor role, proceed to doctorDashboard
                loadDashboard("/view/doctorsDashboard.fxml");
                return; // Exit the method
            }
        }

        // Username or password is incorrect, show an error message
        showErrorDialog("Login Failed", "Invalid username or password. Please try again.");
    }

    private void loadDashboard(String dashboardFXMLPath) throws IOException {
        try {
            AnchorPane load = FXMLLoader.load(getClass().getResource(dashboardFXMLPath));
            loginPane.getChildren().clear();
            loginPane.getChildren().add(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showErrorDialog(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
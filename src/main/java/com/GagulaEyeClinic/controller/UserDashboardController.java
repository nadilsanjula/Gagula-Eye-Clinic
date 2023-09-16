package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserDashboardController {

    @FXML
    private AnchorPane userSecPane;

    @FXML
    private AnchorPane userNaviPanal;

    @FXML
    private JFXButton homeBtn;

    @FXML
    private JFXButton patientBtn;

    @FXML
    private JFXButton btnAppoiments;

    @FXML
    private JFXButton btnMedicine;

    @FXML
    private JFXButton btnSuppliers;

    @FXML
    private JFXButton btnRawMaterial;

    @FXML
    private JFXButton btnEmployees;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDate;

    @FXML
    private JFXTextField SearchBar;

    @FXML
    private JFXButton SearchBtn;

    @FXML
    private Label lblHeading;

    @FXML
    private AnchorPane load;

    @FXML
    void SearchBtnOnAction(ActionEvent event) {

    }

    @FXML
    void btnAppoimentsOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrAppointments.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void btnEmployeesOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrEmployee.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void btnMedicineOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrMedicine.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void btnRawMaterialOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrRawMaterials.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/userPatients.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void homeBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/usrDash.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

    @FXML
    void logoutBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/loginScreen.fxml"));
        userSecPane.getChildren().clear();
        userSecPane.getChildren().add(load);

    }

    @FXML
    void patientBtnOnAction(ActionEvent event) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/userPatients.fxml"));
        load.getChildren().clear();
        load.getChildren().add(root);

    }

}

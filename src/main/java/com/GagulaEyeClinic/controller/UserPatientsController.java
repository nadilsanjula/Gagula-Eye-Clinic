package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.IOException;

public class UserPatientsController {

    @FXML
    private AnchorPane usrPatientPane;

    @FXML
    private JFXTextField txtPatientAge;

    @FXML
    private JFXComboBox<String> comBoxGender;

    @FXML
    private JFXTextField txtPatientId;

    @FXML
    private JFXTextField txtPatientName;

    @FXML
    private JFXTextField txtPatientAddress;

    @FXML
    private JFXTextField txtPatientNIC;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnView;


    @FXML
    void initialize() {
        ObservableList<String> genderOptions = FXCollections.observableArrayList("Male", "Female");
        comBoxGender.setItems(genderOptions);
    }



    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewPatients.fxml"));
        usrPatientPane.getChildren().clear();
        usrPatientPane.getChildren().add(load);

    }

    @FXML
    void comBoxPatientIdOnAction(ActionEvent event) {
        String selectedGender = (String) comBoxGender.getValue();
        if (selectedGender != null) {
            System.out.println("Selected Gender: " + selectedGender);
            // Add your action handling code here
        }
    }

}

package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserAppoinmentDTO;
import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.model.UserAppoinmentModel;
import com.GagulaEyeClinic.model.UserPatientModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class UsrAppointmentsController {

    @FXML
    private AnchorPane useAppoimentsPane;

    @FXML
    private JFXTextField txtAppointmentId;

    @FXML
    private JFXComboBox<String> ComBoxDoctorId;

    @FXML
    private JFXComboBox<String> ComBoxPatientId;

    @FXML
    private JFXComboBox<String> ComBoxPurpose;

    @FXML
    private JFXTimePicker timePickr;

    @FXML
    private JFXDatePicker dtePicker;

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
        ObservableList<String> purposeOptions = FXCollections.observableArrayList("First Time Patients", "Revisit Patients", "Emergency Patients");
        ComBoxPurpose.setItems(purposeOptions); // Correct the ComboBox variable name
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String appId = txtAppointmentId.getText();
        String purpose = ComBoxPurpose.getValue();
        String patId = ComBoxPatientId.getValue();
        String docId = ComBoxDoctorId.getValue();

        UserAppoinmentDTO userAppoinmentDTO = new UserAppoinmentDTO(appId,purpose,patId,docId);

        try {
            boolean isSaved = UserAppoinmentModel.save(userAppoinmentDTO);

            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved :) !!!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Not saved :) !!!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewAppoiments.fxml"));
        useAppoimentsPane.getChildren().clear();
        useAppoimentsPane.getChildren().add(load);
    }

    @FXML
    void txtAppointmentIdOnAction(ActionEvent event) {

    }

    @FXML
    void setComBoxPurpose(ActionEvent event) {
        String selectedPurpose = (String) ComBoxPurpose.getValue();
        if (selectedPurpose != null) {

        }
    }

}

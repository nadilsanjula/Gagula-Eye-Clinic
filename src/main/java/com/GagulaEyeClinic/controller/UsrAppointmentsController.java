package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.db.DBConnection;
import com.GagulaEyeClinic.dto.UserAppoinmentDTO;
import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.model.UserAppoinmetModel;
import com.GagulaEyeClinic.model.UserMedicineModel;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UsrAppointmentsController implements Initializable {

    public Spinner<Integer> txtHour;
    public Spinner<Integer> txtMinite;
    public JFXTimePicker TimePiker;
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
    void btnAddOnAction(ActionEvent event) {
        String appId = txtAppointmentId.getText();
        String date = dtePicker.getAccessibleText();
        String purpose = ComBoxPurpose.toString();
        String docId = ComBoxDoctorId.toString();
        String patId = ComBoxPatientId.toString();

        UserAppoinmentDTO userAppoinmentDTO = new UserAppoinmentDTO(appId, date, purpose, docId, patId);

        try {
            boolean isSaved = UserAppoinmetModel.save(userAppoinmentDTO);


            if (isSaved) {

                new Alert(Alert.AlertType.CONFIRMATION, "Saved :) !!!").show();

            } else {

                new Alert(Alert.AlertType.ERROR, "Not saved :) !!!").show();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





        Integer hour = txtHour.getValueFactory().getValue();
        Integer min = txtMinite.getValueFactory().getValue();
        String Time = hour+" : "+min;
        System.out.println(Time);
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


    SpinnerValueFactory<Integer> hourFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
    SpinnerValueFactory<Integer> minuteFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
             txtHour.setValueFactory(hourFactory);
            txtMinite.setValueFactory(minuteFactory);

        ObservableList<String> genderOptions = FXCollections.observableArrayList("First Time Patients", "Revisit Patients","Emergency Patients");
        ComBoxPurpose.setItems(genderOptions);
    }


    public void TimePikerOnActiokjn(ActionEvent actionEvent) {
    }
}

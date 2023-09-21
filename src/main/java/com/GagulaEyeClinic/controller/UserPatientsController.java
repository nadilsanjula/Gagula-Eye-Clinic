package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.db.DBConnection;
import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.model.UserSupplierModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.GagulaEyeClinic.model.UserPatientModel;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class UserPatientsController implements Initializable {

    private final static String URL = "jdbc:mysql://localhost:3306/gagulawedamadura";
    private final static Properties props = new Properties();

    static {
        props.setProperty("user", "root");
        props.setProperty("password", "Mixage03!");
    }
    @FXML
    public JFXTextField txtDocId;

    @FXML
    public JFXComboBox<String> comBoxDocId;

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
    void btnAddOnAction(ActionEvent event) {
        String patId = txtPatientId.getText();
        String name = txtPatientName.getText();
        String address = txtPatientAddress.getText();
        Integer age = Integer.parseInt(txtPatientAge.getText());
        String nic = txtPatientNIC.getText();
        String contactNum = txtContactNo.getText();
        String gender = comBoxGender.getValue();
        String docId = comBoxDocId.getValue();



        UserPatientDTO userPatientDTO = new UserPatientDTO(patId, name, address, age, nic, contactNum, gender,docId);

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO patient " + " VALUES (?,?,?,?,?,?,?,?)");
            pstm.setString(1,userPatientDTO.getPatId());
            pstm.setString(2,userPatientDTO.getName());
            pstm.setString(3,userPatientDTO.getAddress());
            pstm.setString(4, String.valueOf(userPatientDTO.getAge()));
            pstm.setString(5,userPatientDTO.getNic());
            pstm.setString(6,userPatientDTO.getContactNum());
            pstm.setString(7,userPatientDTO.getGender());
            pstm.setString(8,userPatientDTO.getDocId());

            int add = pstm.executeUpdate();

            if (add > 0)   {

                new Alert(Alert.AlertType.CONFIRMATION, "Saved :) !!!").show();

            } else {

                new Alert(Alert.AlertType.ERROR, "Not saved :) !!!").show();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewPatients.fxml"));
        usrPatientPane.getChildren().clear();
        usrPatientPane.getChildren().add(load);

    }

    @FXML
    void comBoxPatientIdOnAction(ActionEvent event) {
        String selectedGender = (String) comBoxGender.getValue();
        if (selectedGender != null) {

        }
    }

    @FXML
    void patIdOnAction(ActionEvent event) {
        String patId = txtPatientId.getText();

        try {
            UserPatientDTO userPatientDTO = UserPatientModel.search(patId);

            if (userPatientDTO != null) {
                txtPatientNIC.setText(userPatientDTO.getNic());
                txtPatientAddress.setText(userPatientDTO.getAddress());
                txtPatientName.setText(userPatientDTO.getName());
                txtContactNo.setText(userPatientDTO.getContactNum());
                txtPatientAge.setText(String.valueOf(userPatientDTO.getAge()));
                comBoxGender.setValue(userPatientDTO.getGender());


            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid ID").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> genderOptions = FXCollections.observableArrayList("Male", "Female");
        comBoxGender.setItems(genderOptions);
    }
}

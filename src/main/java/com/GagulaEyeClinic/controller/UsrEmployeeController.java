package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.model.UserSupplierModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import com.GagulaEyeClinic.model.UserEmployeeModel;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.input.KeyCode;
import java.util.List;
import java.sql.SQLException;
import com.GagulaEyeClinic.dto.UserEmployeeDTO;
import java.time.LocalDate;
import com.jfoenix.controls.JFXDatePicker;

public class UsrEmployeeController implements Initializable {

    @FXML
    private AnchorPane employeePane;

    @FXML
    private JFXTextField txtEmployeeId;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXTextField txtJobRole;

    @FXML
    private JFXTextField txtContactNo;

    @FXML
    private JFXTextField txtAddress;

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
        String empId = txtEmployeeId.getText();
        String name = txtEmployeeName.getText();
        String address = txtAddress.getText();
        String contactNum = txtContactNo.getText();
        String jobRole = txtJobRole.getText();



        UserEmployeeDTO userEmployeeDTO = new UserEmployeeDTO(empId,name,address,contactNum,jobRole);


        try {
            boolean isSaved = UserEmployeeModel.save(userEmployeeDTO);


            if (isSaved) {

                new Alert(Alert.AlertType.CONFIRMATION, "Saved :) !!!").show();

            } else {

                new Alert(Alert.AlertType.ERROR, "Not saved :) !!!").show();

            }
        } catch (SQLException e) {
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
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewEmployee.fxml"));
        employeePane.getChildren().clear();
        employeePane.getChildren().add(load);

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtContactNoOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmployeeIdOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmployeeNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtJobRoleOnAction(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
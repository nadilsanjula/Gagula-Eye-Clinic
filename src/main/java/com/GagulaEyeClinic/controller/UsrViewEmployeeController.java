package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class UsrViewEmployeeController {

    @FXML
    private AnchorPane usrViewEmployeePane;

    @FXML
    private TableView<?> tblEmployeeDetails;

    @FXML
    private TableColumn<?, ?> colEmpID;

    @FXML
    private TableColumn<?, ?> colEmpName;

    @FXML
    private TableColumn<?, ?> colJobRole;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colJoingDate;

    @FXML
    private JFXButton btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

}

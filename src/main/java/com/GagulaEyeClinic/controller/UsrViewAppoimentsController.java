package com.GagulaEyeClinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class UsrViewAppoimentsController {

    @FXML
    private AnchorPane tblViewAppoiments;

    @FXML
    private TableView<?> tblAppoiments;

    @FXML
    private TableColumn<?, ?> colAppoimentID;

    @FXML
    private TableColumn<?, ?> colDocID;

    @FXML
    private TableColumn<?, ?> colPatientID;

    @FXML
    private TableColumn<?, ?> colPurpose;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private JFXButton btnBack;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

}

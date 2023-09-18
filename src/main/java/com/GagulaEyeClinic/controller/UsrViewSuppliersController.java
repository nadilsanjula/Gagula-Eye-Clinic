package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.model.UserSupplierModel;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UsrViewSuppliersController implements Initializable {



    @FXML
    private AnchorPane usrViewSuppliersPane;

    @FXML
    private TableView<UserSupplierDTO> tblViewSuppliers;

    @FXML
    private TableColumn<?, ?> colSupID;

    @FXML
    private TableColumn<?, ?> colSupName;

    @FXML
    private TableColumn<?, ?> colSupAddress;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colContactNum;

    @FXML
    private JFXButton btnBack;

    ObservableList<UserSupplierDTO> obList= FXCollections.observableArrayList();

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrSuppliers.fxml"));
        usrViewSuppliersPane.getChildren().clear();
        usrViewSuppliersPane.getChildren().add(load);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setCellValueFactory();

    }

    private void getAll() {
        try {
            List<UserSupplierDTO> userSupplierDTOS = UserSupplierModel.getAll();
            for (UserSupplierDTO userSupplierDTO :userSupplierDTOS){
                obList.add(new UserSupplierDTO(userSupplierDTO.getSupId(), userSupplierDTO.getName(), userSupplierDTO.getAddress(), userSupplierDTO.getNic(), userSupplierDTO.getContactNum()));
                System.out.println("10"); }
            tblViewSuppliers.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colSupID.setCellValueFactory(new PropertyValueFactory<>("supId"));
        colSupName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSupAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colContactNum.setCellValueFactory(new PropertyValueFactory<>("contactNum"));
    }
}
package com.GagulaEyeClinic.controller;

import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import com.GagulaEyeClinic.model.UserSupplierModel;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class UsrSuppliersController implements Initializable {

    @FXML
    private AnchorPane suppliersPane;

    @FXML
    private JFXTextField txtSupplierId;

    @FXML
    private JFXTextField txtSupplierName;

    @FXML
    private JFXTextField txtSupplierAddress;

    @FXML
    private JFXTextField txtNic;

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
        String supId = txtSupplierId.getText();
        String name = txtSupplierName.getText();
        String address = txtSupplierAddress.getText();
        String nic = txtNic.getText();
        String contactNum = txtContactNo.getText();


        UserSupplierDTO userSupplierDTO = new UserSupplierDTO(supId,name,address,nic,contactNum);


        try {
            boolean isSaved = UserSupplierModel.save(userSupplierDTO);


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
        try {
            // Assuming you have a way to identify the selected supplier for deletion.
            UserSupplierDTO userSupplierDTO = getSelectedSupplier();

            // Check if a supplier is selected before attempting deletion.
            if (userSupplierDTO != null) {
                String supId = userSupplierDTO.getSupId(); // Get the supId from the DTO

                boolean isDeleted = UserSupplierModel.delete(supId);

                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Deleted successfully :) !!!").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Deletion failed :( !!!").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "No supplier selected for deletion.").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // You can add any cleanup code here if needed.
        }
    }

    // You'll need a method to get the selected supplier from your UI.
    private UserSupplierDTO getSelectedSupplier() {
        // Implement logic to retrieve the selected supplier, e.g., from a list or table.
        // Return the selected UserSupplierDTO or null if no supplier is selected.
        return null;
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewOnAction(ActionEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/usrViewSuppliers.fxml"));
        suppliersPane.getChildren().clear();
        suppliersPane.getChildren().add(load);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
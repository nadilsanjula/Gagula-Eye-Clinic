package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserSupplierModel {
    public static boolean save(UserSupplierDTO UserSupplierDTO) throws SQLException {

        String sql = "INSERT INTO supplier(supId,name,address,nic,contactNum) VALUES(?,?,?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, UserSupplierDTO.getSupId(), UserSupplierDTO.getName(), UserSupplierDTO.getAddress(), UserSupplierDTO.getNic(), UserSupplierDTO.getContactNum());
        return isSaved;
    }
}

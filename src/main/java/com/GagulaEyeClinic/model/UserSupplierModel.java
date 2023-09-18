package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserSupplierModel {
    public static boolean save(UserSupplierDTO UserSupplierDTO) throws SQLException {

        String sql = "INSERT INTO supplier(supId,name,address,nic,contactNum) VALUES(?,?,?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, UserSupplierDTO.getSupId(), UserSupplierDTO.getName(), UserSupplierDTO.getAddress(), UserSupplierDTO.getNic(), UserSupplierDTO.getContactNum());
        return isSaved;
    }

    public static UserSupplierDTO search(String supId) throws SQLException {
        String sql = "SELECT * FROM supplier where supId = ?";

        ResultSet resultSet = CrudUtil.execute(sql, supId);

        if (resultSet.next()){
           UserSupplierDTO userSupplierDTO= new UserSupplierDTO();
            userSupplierDTO.setSupId(resultSet.getString(1));
            userSupplierDTO.setName(resultSet.getString(2));
            userSupplierDTO.setAddress(resultSet.getString(3));
            userSupplierDTO.setNic(resultSet.getString(4));
            userSupplierDTO.setContactNum(resultSet.getString(5));

            return userSupplierDTO;
        }
        return null;
    }

    public static List<UserSupplierDTO> getAll() throws SQLException {
        String sql = "SELECT * FROM supplier";

        ResultSet resultSet = CrudUtil.execute(sql);

        List<UserSupplierDTO> userSupplierDTOS = new ArrayList<>();

        while (resultSet.next()){
            UserSupplierDTO userSupplierDTO= new UserSupplierDTO();
            userSupplierDTO.setSupId(resultSet.getString(1));
            userSupplierDTO.setName(resultSet.getString(2));
            userSupplierDTO.setAddress(resultSet.getString(3));
            userSupplierDTO.setNic(resultSet.getString(4));
            userSupplierDTO.setContactNum(resultSet.getString(5));

            userSupplierDTOS.add(userSupplierDTO);
        }
        return userSupplierDTOS;
    }

}






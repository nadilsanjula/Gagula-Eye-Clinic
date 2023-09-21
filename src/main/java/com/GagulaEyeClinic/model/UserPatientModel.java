package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserPatientDTO;

import java.sql.*;


public class UserPatientModel {
    public static boolean save(UserPatientDTO UserPatientDTO) throws SQLException {

        String sql = "INSERT INTO patient(patId,name,address,age,nic,contactNum,gender,docId) VALUES(?,?,?,?,?,?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, UserPatientDTO.getPatId(), UserPatientDTO.getName(), UserPatientDTO.getAddress(),UserPatientDTO.getAge(),UserPatientDTO.getNic(), UserPatientDTO.getContactNum(), UserPatientDTO.getGender());
        return isSaved;
    }

    public static UserPatientDTO search(String patId) throws SQLException {
        String sql = "SELECT * FROM patient where patId = ?";

        ResultSet resultSet = CrudUtil.execute(sql, patId);

        if (resultSet.next()) {
           UserPatientDTO userPatientDTO = new UserPatientDTO();
            userPatientDTO.setPatId(resultSet.getString(1));
            userPatientDTO.setName(resultSet.getString(2));
            userPatientDTO.setAddress(resultSet.getString(3));
            userPatientDTO.setAge(resultSet.getInt(4));
            userPatientDTO.setNic(resultSet.getString(5));
            userPatientDTO.setContactNum(resultSet.getString(6));
            userPatientDTO.setGender(resultSet.getString(7));


            return userPatientDTO;
        }
        return null;
    }
}
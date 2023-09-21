package com.GagulaEyeClinic.model;


import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserEmployeeDTO;
import com.GagulaEyeClinic.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserEmployeeModel {


    /*public static boolean save(UserEmployeeDTO userEmployeeDTO) {
        *//*String sql = "INSERT INTO employee(empId,name,address,contactNum,jobRole,joinedDate) VALUES(?,?,?,?,?,?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, UserEmployeeDTO.);
        return isSaved;*//*
    }
*/
    public static UserPatientDTO search(String patId) throws SQLException {
        String sql = "SELECT * FROM patient where patId = ?";

        ResultSet resultSet = CrudUtil.execute(sql, patId);

        if (resultSet.next()) {
            UserPatientDTO userPatientDTO = new UserPatientDTO();


            userPatientDTO.setName(resultSet.getString(2));
            userPatientDTO.setAddress(resultSet.getString(3));
            userPatientDTO.setAge(resultSet.getInt(4));
            userPatientDTO.setNic(resultSet.getString(5));
            userPatientDTO.setContactNum(resultSet.getString(6));
            userPatientDTO.setGender(resultSet.getString(7));
            userPatientDTO.setDocId(resultSet.getString(8));


            return userPatientDTO;
        }
        return null;
    }
}

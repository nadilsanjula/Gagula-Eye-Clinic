package com.GagulaEyeClinic.model;


import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserEmployeeDTO;
import com.GagulaEyeClinic.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserEmployeeModel {
    public static boolean save(UserEmployeeDTO UserEmployeeDTO) throws SQLException {

        String sql = "INSERT INTO employee(empId,name,address,contactNum,jobRole) VALUES(?,?,?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, UserEmployeeDTO.getEmpId(), UserEmployeeDTO.getName(), UserEmployeeDTO.getAddress(), UserEmployeeDTO.getContactNum(), UserEmployeeDTO.getJobRole());
        return isSaved;
    }
}

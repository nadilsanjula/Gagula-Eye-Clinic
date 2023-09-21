package com.GagulaEyeClinic.model;


import com.GagulaEyeClinic.dto.UserAppoinmentDTO;
import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserPatientDTO;
import com.GagulaEyeClinic.db.DBConnection;
import java.sql.*;

public class UserAppoinmentModel {
    public static boolean save(UserAppoinmentDTO UserAppoinmentDTO) throws SQLException {

        String sql = "INSERT INTO appoinment(aptId,purpose,docId,patId) VALUES(?,?,?,?)";

        boolean isSaved = CrudUtil.execute(sql,UserAppoinmentDTO.getAppId(),UserAppoinmentDTO.getPurpose(),UserAppoinmentDTO.getDocId(),UserAppoinmentDTO.getPatId());
        return isSaved;
    }
}

package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.MedicineDTO;

import java.sql.SQLException;

public class UserMedicineModel {
    public static boolean save(MedicineDTO MedicineDTO) throws SQLException {

        String sql = "INSERT INTO customer(medId,name,description) VALUES(?,?,?)";

        boolean isSaved = CrudUtil.execute(sql, MedicineDTO.getMedId(), MedicineDTO.getName(), MedicineDTO.getDescription());
        return isSaved;
    }
}

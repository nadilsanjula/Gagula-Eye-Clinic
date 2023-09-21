package com.GagulaEyeClinic.model;

import com.GagulaEyeClinic.util.CrudUtil;
import com.GagulaEyeClinic.dto.UserSupplierDTO;
import com.GagulaEyeClinic.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserSupplierModel {
    /*public static boolean save(UserSupplierDTO UserSupplierDTO) throws SQLException {

        String sql = "INSERT INTO supplier(supId,name,address,nic,contactNum) VALUES(?,?,?,?,?)";

        return CrudUtil.execute(sql, UserSupplierDTO.getSupId(), UserSupplierDTO.getName(), UserSupplierDTO.getAddress(), UserSupplierDTO.getNic(), UserSupplierDTO.getContactNum());
    }*/

    /*public static UserSupplierDTO search(String supId) throws SQLException {
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
*/
    public static boolean update(UserSupplierDTO userSupplierDTO) throws SQLException {
        String sql = "UPDATE supplier set name=?,address=?,nic=?,contactNum=? WHERE supId = ?";
        return CrudUtil.execute(sql,userSupplierDTO.getName(),userSupplierDTO.getAddress(),userSupplierDTO.getNic(), userSupplierDTO.getContactNum(),userSupplierDTO.getSupId());
    }

    public static UserSupplierDTO search(String supId) throws SQLException {
        String sql = "SELECT * FROM supplier WHERE supId = ?";
        ResultSet resultSet = CrudUtil.execute(sql, supId);

        if (resultSet.next()) {
            // Create a UserSupplierDTO and populate it with data from the ResultSet
            UserSupplierDTO userSupplierDTO = new UserSupplierDTO(
                    resultSet.getString("supId"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("nic"),
                    resultSet.getString("contactNum")
            );
            return userSupplierDTO;
        }

        // If no matching record is found, return null
        return null;
    }

    public static boolean remove(String supId) throws SQLException {
        String sql = "DELETE FROM supplier WHERE supId = ?";
        return CrudUtil.execute(sql,supId);
    }

    public static List<UserSupplierDTO> getAll() throws SQLException {
        String sql = "SELECT * FROM supplier";
        ResultSet resultSet = CrudUtil.execute(sql);
        List<UserSupplierDTO> data = new ArrayList<>();
        while (resultSet.next()) {
            UserSupplierDTO userSupplierDTO = new UserSupplierDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
            data.add(userSupplierDTO);
        }
        return data;
    }

    public static boolean save(UserSupplierDTO userSupplierDTO) throws SQLException {
        String sql = "INSERT INTO supplier(supId,name,address,nic,contactNum) VALUES(?,?,?,?,?)";

        return CrudUtil.execute(sql, userSupplierDTO.getSupId(), userSupplierDTO.getName(), userSupplierDTO.getAddress(), userSupplierDTO.getNic(), userSupplierDTO.getContactNum());

    }
}






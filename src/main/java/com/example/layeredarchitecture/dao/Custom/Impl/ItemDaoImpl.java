package com.example.layeredarchitecture.dao.Custom.Impl;

import com.example.layeredarchitecture.dao.Custom.ItemDAO;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDAO {

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT * FROM item");
        ArrayList<ItemDTO> allItems = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDto = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("qtyOnHand"),
                    rst.getInt("unitPrice")
            );
            allItems.add(itemDto);
        }
        return allItems;
    }

    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
//        pstm.setString(1, itemDTO.getCode());
//        pstm.setString(2, itemDTO.getDescription());
//        pstm.setBigDecimal(3, itemDTO.getUnitPrice());
//        pstm.setInt(4, itemDTO.getQtyOnHand());
//
//        return pstm.executeUpdate() > 0;

        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
                itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//        pstm.setString(1, itemDTO.getDescription());
//        pstm.setBigDecimal(2, itemDTO.getUnitPrice());
//        pstm.setInt(3, itemDTO.getQtyOnHand());
//        pstm.setString(4, itemDTO.getCode());
//
//        return pstm.executeUpdate() > 0;
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
//        pstm.setString(1, id);
//
//        return pstm.executeUpdate() > 0;

        return SQLUtil.execute("DELETE FROM Item WHERE code=?",
                id);
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//        pstm.setString(1, id);
//
//        return pstm.executeQuery().next();

        return SQLUtil.execute("SELECT code FROM Item WHERE code=?",
                id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//        pstm.setString(1, newItemCode + "");
//        ResultSet rst = pstm.executeQuery();
//        rst.next();

        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",newItemCode);
        rst.next();
        return new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));

    }

}

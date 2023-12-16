package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    public boolean saveItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;


    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;


    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    public boolean isExist(String id) throws SQLException, ClassNotFoundException;


    public String generateNextId();
}

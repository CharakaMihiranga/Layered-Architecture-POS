package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.SuperDAO;
import com.example.layeredarchitecture.entity.Item;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException;
    public boolean saveItem(Item item) throws SQLException, ClassNotFoundException;
    public boolean updateItem(Item item) throws SQLException, ClassNotFoundException;
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
    public boolean existItem(String id) throws SQLException, ClassNotFoundException;
    public String generateID() throws SQLException, ClassNotFoundException;
    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException;
}

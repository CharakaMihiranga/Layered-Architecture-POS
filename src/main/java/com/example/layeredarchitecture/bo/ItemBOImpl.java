package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.Custom.Impl.ItemDaoImpl;
import com.example.layeredarchitecture.dao.Custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = new ItemDaoImpl();

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.save(itemDTO);
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.update(itemDTO);
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }

    @Override
    public boolean existItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateID();
    }

    @Override
    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException {
        return itemDAO.findItem(newItemCode);
    }
}

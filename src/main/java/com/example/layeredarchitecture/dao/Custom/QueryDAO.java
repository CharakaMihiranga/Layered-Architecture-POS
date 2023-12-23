package com.example.layeredarchitecture.dao.Custom;

import com.example.layeredarchitecture.SuperDAO;
import com.example.layeredarchitecture.model.CustomDTO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.SearchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public ArrayList<SearchDTO> getOrderDetail() throws SQLException, ClassNotFoundException;

}

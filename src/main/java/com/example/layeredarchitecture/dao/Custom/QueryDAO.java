package com.example.layeredarchitecture.dao.Custom;

import com.example.layeredarchitecture.model.CustomDTO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO{
    public ArrayList<OrderDTO> getOrderDetail() throws SQLException, ClassNotFoundException;

}

package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;

public interface CustomerBO {
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException;
}

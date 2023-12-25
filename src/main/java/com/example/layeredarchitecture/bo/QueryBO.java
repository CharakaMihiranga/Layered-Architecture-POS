package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.entity.Search;
import com.example.layeredarchitecture.model.SearchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryBO extends SuperBO {
    public ArrayList<Search> getOrderDetail() throws SQLException, ClassNotFoundException;
}

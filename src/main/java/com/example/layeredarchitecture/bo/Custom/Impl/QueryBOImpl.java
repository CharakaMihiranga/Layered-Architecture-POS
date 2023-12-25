package com.example.layeredarchitecture.bo.Custom.Impl;

import com.example.layeredarchitecture.bo.QueryBO;
import com.example.layeredarchitecture.dao.Custom.QueryDAO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.entity.Search;
import com.example.layeredarchitecture.model.SearchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class QueryBOImpl implements QueryBO {

    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public ArrayList<Search> getOrderDetail() throws SQLException, ClassNotFoundException {
        return queryDAO.getOrderDetail();
    }
}

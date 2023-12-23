package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.Custom.CustomerDAO;
import com.example.layeredarchitecture.dao.Custom.Impl.CustomerDaoImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO{

    CustomerDAO customerDAO=new CustomerDaoImpl();
    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        //customer business logic example
        return customerDAO.save(dto);
    }
}

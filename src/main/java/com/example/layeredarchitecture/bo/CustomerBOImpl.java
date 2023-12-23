package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.Custom.CustomerDAO;
import com.example.layeredarchitecture.dao.Custom.Impl.CustomerDaoImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO{

    CustomerDAO customerDAO=new CustomerDaoImpl();

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        //customer business logic example
        return customerDAO.save(dto);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customerDTO);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public String generateID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

}

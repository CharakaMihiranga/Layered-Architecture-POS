package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public String generateID() throws SQLException, ClassNotFoundException;
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
}
